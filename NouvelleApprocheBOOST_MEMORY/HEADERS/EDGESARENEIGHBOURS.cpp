#include <EDGESARENEIGHBOURS.h>
#include <STRUCTS.h>

//=============test if those edges are neighbours=============================
    bool edgesareneighbours(Graph const& g, E e1, E e2) {

        std::set<vertex_t> vertex_set { 
            source(e1, g), target(e1, g),
            source(e2, g), target(e2, g),
        };

        return graphconnexe(g) && vertex_set.size() < 4;
    }