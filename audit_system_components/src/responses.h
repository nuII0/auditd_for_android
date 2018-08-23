/**
 * resonses.h beinhaltet für jede
 * Art von Response eine eigene Funktion.
 */
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "cjson/cJSON.h"
#include "externalcommand.h"

cJSON* pong_response();
cJSON* audit_rule_list_response();
cJSON* audit_rule_add_response(const char* parameter);
cJSON* audit_rule_delete_response(const char* parameter);
cJSON* ausearch_response(const char* parameter);

