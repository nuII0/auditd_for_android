#include "socketoperations.h"

ssize_t readsize(int fd, void* buf, size_t size) {
	size_t left;
	ssize_t red;
	char *ptr;

	ptr = buf;
	left = size;
	while (left > 0) {
		fflush(stdout);
		if ((red = read(fd, ptr, left)) < 0) {
			if (errno == EINTR)
				red = 0; // read() erneut aufrufen
			else
				return (-1); // Fehlerfall
		} else if (red == 0) {
			break;
		}
		left -= red;
		fflush(stdout);
		ptr += red;
	}
	return (size - red);
}

ssize_t writesize(int fd, const void* buf, size_t size) {
	size_t left;
	ssize_t written;
	const char *ptr;
	ptr = buf;
	left = size;
	while (left > 0) {
		if ((written = write(fd, ptr, left)) <= 0) {
			if ((written < 0) && (errno == EINTR))
				written = 0; // write() erneut aufrufen
			else {
				printf("Fehler beim Schreiben in den Socket\n");
				printf("errno: %d", errno);
				return (-1);
			}
		}
		left -= written;
		ptr += written;
	}
	return size;
}

ssize_t readline(int fd, char ** out) 
{ 
	int buf_size = 0; 
	int in_buf = 0; 
	int ret;
	char ch; 
	char * buffer = NULL; 
	char * new_buffer;

	do
	{
		// Lese ein einzelnes Byte
		ret = read(fd, &ch, 1);
		if (ret < 1)
		{
			// Fehlerfall oder Disconnect
			free(buffer);
			return -1;
		}

		// Wurde das Zeilenende erreicht?
		if (ch == '\n') 
			break; // yes

		// Wird mehr Speicher benötigt?
		if ((buf_size == 0) || (in_buf == buf_size)) 
		{ 
			buf_size += 128; 
			new_buffer = realloc(buffer, buf_size); 

			if (!new_buffer) 
			{ 
				free(buffer);
				return -1;
			} 

			buffer = new_buffer; 
		} 

		buffer[in_buf] = ch; 
		++in_buf; 
	} 
	while (1);

	/** Wenn das Zeilenende "\r\n" ist, dann ignoriere "\r",
	 * weil "\n" ausreichend ist als Terminator.
	 */
	if ((in_buf > 0) && (buffer[in_buf-1] == '\r'))
		--in_buf;

	// Wird mehr Speicher benötigt?
	if ((buf_size == 0) || (in_buf == buf_size)) 
	{ 
		++buf_size; 
		new_buffer = realloc(buffer, buf_size); 

		if (!new_buffer) 
		{ 
			free(buffer);
			return -1;
		} 

		buffer = new_buffer; 
	} 

	// Hinzufügen des Null-Terminators
	buffer[in_buf] = '\0';

	*out = buffer; // Die Zeile wurde fertig ausgelesen

	return in_buf; /** Gebe die Anzahl der Chars in der ausgelesene Line zurück.
					 * Das Newline-Zeichen und der Null-Terminator sind nicht enthalten.
					 */
}

int getSO_ERROR(int fd) {
	int err = 1;
	socklen_t len = sizeof err;
	if (-1 == getsockopt(fd, SOL_SOCKET, SO_ERROR, (char *)&err, &len)) {
		printf("Fataler Fehler: SO_ERROR \n");
		exit(1);
	}
	if (err)
		errno = err;              // Setze Fehler auf SO_ERROR
	return err;
}

void close_socket(int fd) {
	if (fd >= 0) {
		getSO_ERROR(fd);
		if (shutdown(fd, SHUT_RDWR) < 0)
			if (errno != ENOTCONN && errno != EINVAL)
				printf("Socket wird geschlossen.\n");
		if (close(fd) < 0)
			printf("Socket ist geschlossen.\n");
	}
}
