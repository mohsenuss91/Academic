#include <GETPOS.h>

//============Get a string starting from pos============
string getpos(int const& pos, string const& yy) {
    size_t i = pos;
    string str;
    for (; yy[i] != ' ' && i < yy.length(); i++)
        str += yy[i];
    return str;
}