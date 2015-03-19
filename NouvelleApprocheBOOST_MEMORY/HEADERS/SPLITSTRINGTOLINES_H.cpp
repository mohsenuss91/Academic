#include <SPLITSTRINGTOLINES.h>
//==========SPLIT THE STRING BY NEWLINE (\n) ==========
vector<string> splitstringtolines(string const& str) {
    vector<string> split_vector;
    split(split_vector, str, is_any_of("\n"));

    return split_vector;
}
