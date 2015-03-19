#include <EDGEEXIST.h>
#include <STRUCTS.h>
//=============test if the given edge exist in the graph===========================
bool edgeexist(Graph const& g, int const& fromid, int const& toid, unsigned const& elabel) {
    int bn = 0;
    if (graphconnexe(g)) {
        if (num_edges(g) != 0) {
            edge_pair ep;
            for (ep = edges(g); ep.first != ep.second; ++ep.first) // ep edge number
            {
                vertex_t from = source(*ep.first, g);
                vertex_t to = target(*ep.first, g);
                edge_t edg = edge(from, to, g);

                if ((g[from].id == fromid) && (g[to].id == toid) && (g[edg.first].label == elabel)) {
                    bn++;
                }
            }
        }
    }

    return (bn != 0);
}
