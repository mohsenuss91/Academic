#include <GRAPHCONNEXE.h>
#include <STRUCTS.h>
//============test if the graph connectivity========================================================
bool graphconnexe(Graph const& g) { 
    return num_edges(g) >= num_vertices(g) - 1; 
}