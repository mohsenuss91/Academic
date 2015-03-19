#ifndef VERTICEEXIST_H   
#define VERTICEEXIST_H

#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/vf2_sub_graph_iso.hpp>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

bool verticeexist(Graph const& g, int const& vId, int const& vlabel);

#endif