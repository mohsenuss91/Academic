#include <VERTICEEXIST.h>
#include <STRUCTS.h>
//=================test if the given vertice exist in the graph=========================
bool verticeexist(Graph const& g, int const& vId, int const& vlabel) {
    int cpt = 0;
    if (num_edges(g) != 0) {
        for (size_t i = 0; i < num_vertices(g); ++i) // size_t vertice number in the graph
        {
            if ((g[i].id == vId) && (g[i].label == vlabel)) {
                cpt++;
            }
        }
    }
    return cpt != 0;
}