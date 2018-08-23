/* forensikmediator.c --
 *
 * Der 'forensikmediator' stellt einen UNIX-Namespace-Socket
 * mit dem Namen 'org.nuii0.nuii0.androidforensik.socket'
 * bereit.
 *
 * Die Android-App 'AndroidForensik' verbindet sich auf diesen Socket.
 *
 * Durch ein spezifiertes Protokoll können der 'forensikmediator'
 * und 'AndroidForensik' miteinander im Request/Response-Verfahren
 * kommunizieren.
 */
#include <sys/un.h>
#include <sys/socket.h>


#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "cjson/cJSON.h"
#include "externalcommand.h"
#include "requesthandling.h"
#include "socketoperations.h"

void request_loop() {
	char *jsonString;

	int sockfd = 0, connfd = 0;
	struct sockaddr_un addr;

	u_int8_t buf[158];

	memset(&addr, 0, sizeof(struct sockaddr_un));
	addr.sun_family = AF_UNIX;

	char str[] = "org.nuii0.nuii0.androidforensik.socket";
	strncpy(&addr.sun_path[1], str, strlen(str));

	sockfd = socket(AF_UNIX, SOCK_STREAM, 0);
	if (sockfd == -1)
		printf("Erzeugung des Sockets ist fehlgeschlagen.\n");

	if (bind(sockfd, (struct sockaddr *) &addr,
				sizeof(sa_family_t) + strlen(str) + 1) == -1)
		printf("Binden des Sockets ist fehlgeschlagen.\n");

	listen(sockfd, 5);

	/**
	 * Ewige while-Schleife, die immer wieder
	 * auf eingehende Verbindungen wartet.
	 */
	while (1) {
		printf("Warten auf eingehende Verbindungen.\n");
		connfd = accept(sockfd, (struct sockaddr*)NULL, NULL);
		printf("Verbindung hergestellt\n");

		/**
		 * Ewige while-Schleife, die immer wieder
		 * auf eingehende Requests wartet und diese beantwortet
		 *
		 * Es kann immer nur eine offene Verbindung bestehen.
		 */
		while(1) {
			cJSON *request;
			if (!(request = receive_request(connfd))) {
				printf("Fehler beim Empfangen eines Requests.\n");
				break;
			}

			jsonString = cJSON_Print(request);

			printf("Empfangener String: %s\n", jsonString);
			free(jsonString);

			cJSON* response;
			if (!(response = build_response(request))) {
				printf("Fehler beim Verarbeiten eines Requests.\n");
				break;
			};

			jsonString = cJSON_Print(response);
			printf("Response Groesse: %s\n", jsonString);
			free(jsonString);

			if (!(send_request(connfd, response))) {
				printf("Fehler beim Senden der Response.\n");
				break;
			};

			cJSON_Delete(request);
			cJSON_Delete(response);
		}

		close_socket(connfd);
	}
}

int main(int argc, char *argv[])
{
	request_loop();
	exit(EXIT_SUCCESS);
}


