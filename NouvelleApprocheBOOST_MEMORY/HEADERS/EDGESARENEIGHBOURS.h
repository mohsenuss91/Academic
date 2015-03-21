#ifndef EDGESARENEIGHBOURS_H
#define EDGESARENEIGHBOURS_H

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
template <typename Graph, typename E = typename boost::graph_traits<Graph>::edge_descriptor>
bool edgesareneighbours(Graph const& g, E e1, E e2);

#endif
