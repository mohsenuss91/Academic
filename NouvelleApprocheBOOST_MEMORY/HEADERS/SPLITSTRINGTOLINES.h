#ifndef SPLITSTRINGTOLINES_H   
#define SPLITSTRINGTOLINES_H

#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/vf2_sub_graph_iso.hpp>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>



vector<string> splitstringtolines(string const& str);

#endif