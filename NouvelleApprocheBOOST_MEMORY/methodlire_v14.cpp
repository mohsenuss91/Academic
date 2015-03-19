#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/vf2_sub_graph_iso.hpp>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <ctime>
#include <queue> // std::queue
// for mmap:
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
//methods
#include <HEADERS/HANDLE_ERROR.h>
#include <HEADERS/CREATEGRAPHS.h>
#include <HEADERS/EDGEEXIST.h>
#include <HEADERS/EDGESARENEIGHBOURS.h>
#include <HEADERS/GETPOS.h>
#include <HEADERS/GRAPHCONNEXE.h>
#include <HEADERS/HANDLE_ERROR.h>
#include <HEADERS/PRINTGRAPH.h>
#include <HEADERS/READFROMFILE.h>
#include <HEADERS/SPLITSTRINGTOLINES.h>
#include <HEADERS/VERTICEEXIST.h>
#include <HEADERS/VERTICESARENEIGHBOURS.h>
#include <HEADERS/STRUCTS.h>
//namespace
using namespace std;
using namespace boost;

//==========STRUCTURES==========
// vertex
struct VertexProperties {
    int id;
    int label;
    VertexProperties(unsigned i = 0, unsigned l = 0) : id(i), label(l) {}
};

// edge
struct EdgeProperties {
    unsigned id;
    unsigned label;
    EdgeProperties(unsigned i = 0, unsigned l = 0) : id(i), label(l) {}
};

// Graph
struct GraphProperties {
    unsigned id;
    unsigned label;
    GraphProperties(unsigned i = 0, unsigned l = 0) : id(i), label(l) {}
};

// adjency list
typedef boost::adjacency_list<boost::vecS, boost::vecS, boost::undirectedS, VertexProperties, EdgeProperties,
                              GraphProperties> Graph;

// descriptors

typedef boost::graph_traits<Graph>::vertex_descriptor vertex_t;
typedef std::pair<boost::graph_traits<Graph>::edge_descriptor, bool> edge_t;
// iterators
typedef graph_traits<Graph>::vertex_iterator vertex_iter;
typedef graph_traits<Graph>::edge_iterator edge_iter;
typedef std::pair<edge_iter, edge_iter> edge_pair;

template <typename Graph, typename E = typename boost::graph_traits<Graph>::edge_descriptor>
//=================callback used fro subgraph_iso=================================================================
struct my_callback {
    template <typename CorrespondenceMap1To2, typename CorrespondenceMap2To1>
    bool operator()(CorrespondenceMap1To2 f, CorrespondenceMap2To1 g) const {
        return false;
    }
};




//=========================================================
/*bool gUe(Graph &g, edge_iter ep, Graph t) {

    vertex_t from = source(*ep, t);
    vertex_t to = target(*ep, t);

    Graph::edge_descriptor copied_edge = boost::add_edge(from, to, t[*ep], g).first;

    g[source(copied_edge, g)] = t[from];
    g[target(copied_edge, g)] = t[to];

    if (graphconnexe(g) && graphconnexe(t)) {
        return vf2_subgraph_iso(g, t, my_callback());
    } else {
        return false;
    }
}*/

//=============test if those edges are neighbours=============================
    


//==============================M A I N   P R O G R A M =======================================
int main() {
    clock_t start = std::clock();
    size_t length;    

    std::vector<Graph> dataG = creategraphs(splitstringtolines(readfromfile("testgUe.txt", length)));

    typedef std::pair<edge_iter, edge_iter> edge_pair;

      if (!dataG.empty()) {

        cout<<"graphconnexe?"<<graphconnexe(dataG[0])<<endl;
        cout<<"verticeexist?"<<verticeexist(dataG[0],1,4)<<endl;
        cout<<"verticeexist?"<<verticeexist(dataG[0],4,2)<<endl;
        cout<<"verticesareneighbours?"<<verticesareneighbours(dataG[0],1,4)<<endl;
        cout<<"verticesareneighbours?"<<verticesareneighbours(dataG[0],4,2)<<endl;
        cout<<"edgeexist?"<<edgeexist(dataG[0],1,4,16)<<endl;
        cout<<"edgeexist?"<<edgeexist(dataG[0],1,4,12)<<endl;
        
        edge_pair ep = edges(dataG[0]);

        if (size(ep) >= 2) {
             Graph::edge_descriptor e1 = *ep.first++;
             Graph::edge_descriptor e2 = *ep.first++;                                                    
             cout << "edgesareneighbours?" << edgesareneighbours(dataG[0], e1, e2) << endl;
             
        }
    }

    // end and time
    cout << "FILE Contains " << dataG.size() << " graphs.\nTIME: " << (std::clock() - start) / (double)CLOCKS_PER_SEC
         << "s" << endl; // fin du programme.
}