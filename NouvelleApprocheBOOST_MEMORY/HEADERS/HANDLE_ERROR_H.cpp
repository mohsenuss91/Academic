#include <HANDLE_ERROR.h>

//==========handle_error==========
void handle_error(const char *msg) {
    perror(msg);
    exit(255);
}