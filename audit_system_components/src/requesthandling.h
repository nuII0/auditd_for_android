/**
 * requesthandling.h beinhaltet Funktionen
 * die sich mit der Verarbeitung von eingehenden Requests
 * und der Erzeugung von dazugehöhrigen Responses
 * beschäftigen 
 */
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "cjson/cJSON.h"
#include "responses.h"
#include "socketoperations.h"

/** 
 * Das Feld, welches die Größe von Request und Responsepaketen
 * angibt ist 8 Byte gross.
 */
static const int sizefield_length = 8;

/** Diese Funktion liest einen eingehenden Request
 * aus dem Filedeskriptor (Socket) aus
 * und gibt den Payload als JSON-Objekt zurück.
 */
cJSON* receive_request(int fd);

/** Diese Funktion nimmt einen Filedeskriptor (Socket
 * und ein JSON-Objekt und schickt dieses als Response
 * über den Socket.
 */

bool send_request(int fd, cJSON* request);

/** Diese Funktion nimmt ein Request entgegen und baut
 * daraus den dazugehöhrigen Response.
 */
cJSON* build_response(const cJSON* request);


