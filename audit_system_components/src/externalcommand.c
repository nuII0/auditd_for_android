#include "externalcommand.h"

char* concat(const char *s1, const char *s2)
{
    char *result = malloc(strlen(s1)+strlen(s2)+1); // +1 wegen dem Null-Terminator
    strcpy(result, s1);
    strcat(result, s2);
    return result;
}

char** auditctl(const char* args, int* lines) {
	FILE *fp;
	char path[1035];

	char* command = concat("/system/bin/auditctl ", args);
	fp = popen(command, "r");
	if (fp == NULL) {
		printf("Fehler beim Ausfuehren von auditctl.\n" );
		exit(1);
	}

	free(command);

	char** tmp = malloc(sizeof(path) * sizeof(char*));

	int i = 0;
	while (fgets(path, sizeof(path)-1, fp) != NULL) {
		printf("%s", path);
		tmp[i] = malloc(sizeof(path));
		strcpy(tmp[i], path);
		i++;
	}
	*lines = i;
	return tmp;
}

char** ausearch(const char* args, int* lines) {
	FILE *fp;
	char path[111035];
	char alternative_search[] = "-k networkactivity";

		printf("Args: %s\n", args);
	char* command;
	if (strcmp(args, alternative_search) == 0) {
		/**
		 * Alternativer Befehl, weil 'ausearch' keine SOCKADDR
		 * Einträge zurückliefern.
		 */
		command = concat("echo -e \"--\n$(/system/bin/cat /storage/audit_stream.txt | /system/bin/grep \"SOCKADDR AF_INET\" -B 2)\"","");
		printf("command is: %s\n", command);

	} else {
		command = concat("/system/bin/ausearch -l -if /storage/audit_stream.txt ", args);
	}

	fp = popen(command, "r");
	if (fp == NULL) {
		printf("Fehler beim Ausfuehren von ausearch.\n" );
		exit(1);
	}

	free(command);

	char** tmp = malloc(sizeof(path) * sizeof(char*));

	int i = 0;
	while (fgets(path, sizeof(path)-1, fp) != NULL) {
		printf("%s", path);
		tmp[i] = malloc(sizeof(path));
		strcpy(tmp[i], path);
		i++;
	}
	*lines = i;
	return tmp;
}

void free_command(char** cmd, int lines) {
	int i;
	for (i = 0; i < lines; i++ )
	{
		free(cmd[i]);
	}
	free(cmd);
}
