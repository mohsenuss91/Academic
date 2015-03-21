#ifndef READFROMFILE_H   
#define READFROMFILE_H

#include <fstream>
#include <iostream>
#include <string>
// for mmap:
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>

const char *readfromfile(const char *fname, size_t &length);

#endif