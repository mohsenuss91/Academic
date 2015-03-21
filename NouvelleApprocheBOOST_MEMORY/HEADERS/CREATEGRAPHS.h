#ifndef CREATEGRAPHS_H
#define CREATEGRAPHS_H

#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/vf2_sub_graph_iso.hpp>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include "STRUCTS.h"
using namespace std;
std::vector<Graph> creategraphs(std::vector<string> const& fichlines);

#endif
