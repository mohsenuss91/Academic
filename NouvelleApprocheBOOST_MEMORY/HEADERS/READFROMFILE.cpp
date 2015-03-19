#include <READFROMFILE.h>
#include <STRUCTS.h>

//============READ ALL THE FILE AND RETURN A STRING===================
const char *readfromfile(const char *fname, size_t &length) {
    int fd = open(fname, O_RDONLY);
    if (fd == -1)
        handle_error("open");

    // obtain file size
    struct stat sb;
    if (fstat(fd, &sb) == -1)
        handle_error("fstat");

    length = sb.st_size;

    const char *addr = static_cast<const char *>(mmap(NULL, length, PROT_READ, MAP_PRIVATE, fd, 0u));
    if (addr == MAP_FAILED)
        handle_error("mmap");

    // TODO close fd at some point in time, call munmap(...)
    return addr;
}