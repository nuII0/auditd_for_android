/**
 * In dieser Datei sind Funktionen für Aufrufe von externen
 * Kommandozeilenprogrammen.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

/**
 * Aufruf von 'auditctl'.
 * Die Argumente werden als Char-Pointer übergeben.
 * Die Ergebnisse des Aufrufs werden als Char-Array zurückgegeben.
 * Ausserdem wird die Zeile der ausgelesenen Zeilen als OUT-Paramter
 * in lines geschrieben */
char** auditctl(const char* args, int* lines);

/**
 * Aufruf von 'ausearch'.
 * Die Argumente werden als Char-Pointer übergeben.
 * Die Ergebnisse des Aufrufs werden als Char-Array zurückgegeben.
 * Ausserdem wird die Zeile der ausgelesenen Zeilen als OUT-Paramter
 * in lines geschrieben */
char** ausearch(const char* args, int* lines);

/** Mit dieser Funktion können die zurückgegeben
 * Ergebnisse aus den vorherigen beiden Funktionen
 * wieder gelöscht werden. */
void free_command(char** cmd, int lines);
