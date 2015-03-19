#include <VERTICESARENEIGHBOURS.h>
#include <STRUCTS.h>

// =============test if thoses vertices are neighbours============================
bool verticesareneighbours(Graph const& g, int const& a, int const& b) {
    int bn = 0;
    if (graphconnexe(g)) {

        if (num_edges(g) != 0) {
            edge_pair ep;
            for (ep = edges(g); ep.first != ep.second; ++ep.first) // ep edge number
            {
                vertex_t from = source(*ep.first, g);
                vertex_t to = target(*ep.first, g);

                if (((g[from].id == a) || (g[to].id == a)) && ((g[from].id == b) || (g[to].id == b))) {
                    bn++;
                }
            }
        }
    }

    return (bn != 0);
}