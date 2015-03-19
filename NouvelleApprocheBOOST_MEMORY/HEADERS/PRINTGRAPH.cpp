#include <PRINTGRAPH.h>
#include <STRUCTS.h>
//====================print the graph information========================================================
void printgraph(Graph const& gr) {
    typedef std::pair<edge_iter, edge_iter> edge_pair;

    std::cout << " contains " << num_vertices(gr) << " vertices, and " << num_edges(gr) << " edges " << std::endl;
    if (graphconnexe(gr)) {

        // Vertex list
        if (num_vertices(gr) != 0) {
            std::cout << "  Vertex list: " << std::endl;
            for (size_t i = 0; i < num_vertices(gr); ++i) // size_t vertice number in the graph
            {
                std::cout << "   v[" << i << "]   ID: " << gr[i].id << ", Label: " << gr[i].label << std::endl;
            }
        }
        // Edge list
        if (num_edges(gr) != 0) {
            std::cout << "  Edge list: " << std::endl;
            edge_pair ep;
            for (ep = edges(gr); ep.first != ep.second; ++ep.first) // ep edge number
            {
                vertex_t from = source(*ep.first, gr);
                vertex_t to = target(*ep.first, gr);
                edge_t edg = edge(from, to, gr);
                std::cout << "   e(" << gr[from].id << "," << gr[to].id << ")   ID: " << gr[edg.first].id
                          << " ,  Label: " << gr[edg.first].label << std::endl;
            }
        }
        std::cout << "\n\n" << std::endl;
    } else {
        cout << "Please check this graph connectivity." << endl;
    }
}