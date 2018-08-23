#include "responses.h"

cJSON* pong_response() {
	cJSON* tmp = cJSON_CreateObject();
	cJSON_AddNumberToObject(tmp, "id", 1);
	return tmp;
}

cJSON* audit_rule_list_response() {
	cJSON* tmp = cJSON_CreateObject();
	cJSON_AddNumberToObject(tmp, "id", 111);
	
	cJSON* entries = cJSON_CreateArray();

	cJSON_AddItemToObject(tmp, "entries", entries);

	int lines;
	char** output = auditctl("-l", &lines);

	int i;
	for (i = 0; i < lines; i++) {
		cJSON_AddItemToArray(entries, cJSON_CreateString(strtok(output[i], "\n")));
	}

	free_command(output, lines);
	return tmp;
}

cJSON* audit_rule_add_response(const char* parameter) {
	cJSON* tmp = cJSON_CreateObject();
	cJSON_AddNumberToObject(tmp, "id", 222);

	int lines;
	char** output = auditctl(parameter, &lines);

	cJSON_AddNumberToObject(tmp, "success", true);

	return tmp;
}

cJSON* audit_rule_delete_response(const char* parameter) {
	cJSON* tmp = cJSON_CreateObject();
	cJSON_AddNumberToObject(tmp, "id", 333);

	int lines;
	char** output = auditctl(parameter, &lines);

	cJSON_AddNumberToObject(tmp, "success", true);

	return tmp;
}

cJSON* ausearch_response(const char* parameter) {
	cJSON* tmp = cJSON_CreateObject();
	cJSON_AddNumberToObject(tmp, "id", 444);
	
	cJSON* entries = cJSON_CreateArray();

	cJSON_AddItemToObject(tmp, "entries", entries);

	int lines;
	char** output = ausearch(parameter, &lines);

	int i;
	for (i = 0; i < lines; i++) {
		cJSON_AddItemToArray(entries, cJSON_CreateString(strtok(output[i], "\n")));
	}

	free_command(output, lines);
	return tmp;
}
