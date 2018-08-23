/* socketoperations.h beinhaltet Funktionen um
 * auf Byte-Ebene in einen Socket zu schreiben bzw.
 * daraus zu lesen
 *
 * Die standarisierten write() und read() Operationen auf einen
 * Socket geben keine Garantie über die tatsächlich gelesenen Bytes,
 * daher sind die hier definierten Funktionen readsize() und writesize()
 * nötig.
 *
 * Die Funktionen wurden sind inspiriert und ähnlich zu denen aus 
 * http://www.informit.com/articles/article.aspx?p=169505&seqNum=9
 */
#include <unistd.h>
#include <stdio.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <errno.h>    
#include <stdlib.h>

ssize_t readsize(int fd, void* buf, size_t size);
ssize_t writesize(int fd, const void* buf, size_t size);

/* Diese Funktion liest eine gesamte Zeile aus dem Socket
 * bis zum Newline-Terminator \n 
 * Quelle: https://stackoverflow.com/questions/9828752/read-line-by-line-from-a-socket-buffer
 */
ssize_t readline(int fd, char** out);

void close_socket(int fd);
int getSO_ERROR(int fd);
