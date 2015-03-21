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
#include "HEADERS/HANDLE_ERROR.h"
#include "HEADERS/CREATEGRAPHS.h"
#include "HEADERS/EDGEEXIST.h"
#include "HEADERS/EDGESARENEIGHBOURS.h"
#include "HEADERS/GETPOS.h"
#include "HEADERS/GRAPHCONNEXE.h"
#include "HEADERS/HANDLE_ERROR.h"
#include "HEADERS/PRINTGRAPH.h"
#include "HEADERS/READFROMFILE.h"
#include "HEADERS/SPLITSTRINGTOLINES.h"
#include "HEADERS/VERTICEEXIST.h"
#include "HEADERS/VERTICESARENEIGHBOURS.h"
#include "HEADERS/STRUCTS.h"
//namespace
using namespace std;
using namespace boost;

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
