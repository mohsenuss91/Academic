#include <STRUCTS.h>
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