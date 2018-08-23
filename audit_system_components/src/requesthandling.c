#include "requesthandling.h"

bool send_request(int fd, cJSON* request) {
	char *json_string = cJSON_Print(request);
	size_t response_size = htonl(strlen(json_string));

	printf("Senden der Responsesize %d\n", ntohl(response_size));
	writesize(fd, &response_size, sizeof(response_size));
	printf("Senden der Responsedaten \n");
	writesize(fd, json_string, strlen(json_string));
	free(json_string);

	return true;
}

/**
 * fd - der Filedeskriptor auf den Socket
 */
cJSON* receive_request(int fd){
	/**
	 * Die Request-Size hat die Gröse eines Int-Wertes
	 */
	size_t request_size;
	cJSON* tmp;
	/**
	 * Laut Protokoll ist einem Request dessen Gröse
	 * als Int-Wert vorangestellt.
	 * Diese wird hier ausgelesen.
	 */
	readsize(fd, &request_size, sizeof(request_size));
	request_size = ntohl(request_size);
	printf("Request size ist: %zu\n", request_size);
	if (request_size > 1000) {
		printf("Ignoriere Request, weil zu gross.\n");
		return NULL;
	}

	/**
	 * Allokiere genug Speicher für den eingehenden Request
	 */
	char request[request_size];
	/**
	 * lese den request aus dem socket aus
	 */
	readsize(fd, &request, sizeof(request));

	/**
	 * Laut Protokoll ist nur gültiges JSON erlaubt,
	 * daher kann dieses hier direkt geparsed werden
	 */
	tmp = cJSON_Parse(request);

	if (tmp == NULL) {
		printf("Fehler beim Parsen von JSON");
		cJSON_Delete(tmp);
	}

	/**
	 * Rückgabe des Requests
	 */
	return tmp;
}


cJSON* build_response(const cJSON* request) {
	/**
	 * Anhand der ID des Requests,
	 * wird festgestellt, welche
	 * Response benötigt wird.
	 */
	cJSON* id_item = cJSON_GetObjectItemCaseSensitive(request, "id");
	size_t id;

	if (cJSON_IsNumber(id_item)) {
		id = id_item->valueint;
		printf("Id des Request ist: %d\n", id);
	} else {
		printf("Der empfangene Request hat keine Id oder Id ist keine Zahl\n");
		return NULL;
	}

	/**
	 * Mögliche Response mit dazugehöhriger
	 * Funktion erstellen.
	 */
	cJSON* id_param;
	cJSON* tmp;
	switch(id) {
		case 0:
			printf("PingRequest erhalten\n");
			tmp = pong_response();
			break;
		case 1:
			printf("AuditRuleListRequest erhalten\n");
			tmp = audit_rule_list_response();
			break;
		case 2:
			printf("AuditRuleAddRequest erhalten\n");
			id_param = cJSON_GetObjectItemCaseSensitive(request, "rule");
			tmp = audit_rule_add_response(id_param->valuestring);
			break;
		case 3:
			printf("AuditRuleDeleteRequest erhalten\n");
			id_param = cJSON_GetObjectItemCaseSensitive(request, "rule");
			tmp = audit_rule_delete_response(id_param->valuestring);
			break;
		case 4:
			printf("AusearchRequest erhalten\n");
			id_param = cJSON_GetObjectItemCaseSensitive(request, "param");
			tmp = ausearch_response(id_param->valuestring);
			break;

		default:
			printf("Request mit unbekannter id erhalten: %d\n",id);
			return NULL;
	}

	/**
	 * Rückgabe der Response
	 */
	return tmp;
}
