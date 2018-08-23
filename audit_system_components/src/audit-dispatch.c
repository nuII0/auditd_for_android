/* audit_dispatch.c --
 *
 * Beschreibung:
 * Dieses Programm verbindet sich auf den Socket /dev/audit
 * und liest die dort anfallenden Informationen zeilenweise aus
 * und schreibst diese nach /storage/audit_stream.txt.
 *
 * Der Audit-Daemon schreibt seine Ereignisse nach /dev/audit.
 * Die Inhalte in /storage/audit_stream.txt können dann von
 * anderen Programmen (z.B. ausearch) analysiert und
 * interpetiert werden.
 */
#include <sys/un.h>
#include <sys/socket.h>

#include "socketoperations.h"

#define AUDIT_SOCKET "/dev/audit"
#define AUDIT_STREAM_FILE "/storage/audit_stream.txt"

void main_loop() {

	int sockfd = 0, rc = 0;
	struct sockaddr_un addr;

	memset(&addr, 0, sizeof(struct sockaddr_un));
	addr.sun_family = AF_UNIX;

    strcpy(addr.sun_path, AUDIT_SOCKET);

	sockfd = socket(AF_UNIX, SOCK_STREAM, 0);
	if (sockfd == -1){
		printf("Erzeugung des Sockets ist fehlgeschlagen.\n");
		close_socket(sockfd);
		exit(EXIT_FAILURE);
	}

	rc = connect(sockfd, (struct sockaddr *) &addr, sizeof(struct sockaddr_un));
	if (rc < 0) {
		printf("Connect zum Auditstream ist fehlgeschlagen.\n");
		close_socket(sockfd);
		exit(EXIT_FAILURE);
	}


	FILE *f = fopen(AUDIT_STREAM_FILE, "ab");
	if (f == NULL)
	{
		printf("Fehler beim Oeffnen der Audit Stream Datei.\n");
		close_socket(sockfd);
		exit(EXIT_FAILURE);
	}

	char* line;
	ssize_t linelength;
	while (1) {
		linelength = readline(sockfd, &line);
		if (linelength < 0) {
			printf("Lesen aus dem Auditstream ist fehlgeschlagen.\n");
			close_socket(sockfd);
			fclose(f);
			exit(EXIT_FAILURE);
		} else if (linelength == 0) {
			/*printf("Warnung: Leere Line gelesen.");*/
		} else {
			printf("%s\n", line);
			fprintf(f, "%s\n", line);
			fflush(f);
		}
		free(line);
	}
	fclose(f);
}

int main(int argc, char *argv[])
{
	main_loop();
	exit(EXIT_SUCCESS);
}


