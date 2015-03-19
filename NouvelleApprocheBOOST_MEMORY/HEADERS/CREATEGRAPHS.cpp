#include <CREATEGRAPHS.h>
#include <STRUCTS.h>
//==================read string vector and return graphs vector===================
std::vector<Graph> creategraphs(std::vector<string> const& fichlines) {
    std::vector<Graph> dataG;
    int compide = 0; // compteur de id edge
    for (string yy : fichlines) {
        switch (yy[0]) {
        case 't': {
            string str2 = getpos(4, yy);
            unsigned gid = atoi(str2.c_str());
            dataG.emplace_back(GraphProperties(gid, gid));
            compide = 0;
        } break;
        case 'v': {
            assert(!dataG.empty()); // assert will terminate the program  if its argument turns out to be false
            // cout<<yy<<endl;
            int vId, vLabel;
            string vvv = getpos(2, yy);
            vId = atoi(vvv.c_str());
            string vvvv = getpos((int)vvv.length() + 3, yy);
            // cout<<vvvv<<endl;
            vLabel = atoi(vvvv.c_str());
            boost::add_vertex(VertexProperties(vId, vLabel), dataG.back());
        }

        break;

        case 'e': { // cout<<yy<<endl;
            assert(!dataG.empty()); // assert will terminate the program  if its argument turns out to be false

            int fromId, toId, eLabel;
            string eee = getpos(2, yy);
            // cout<<eee<<endl;
            fromId = atoi(eee.c_str());
            string eee2 = getpos((int)eee.length() + 3, yy);
            // cout<<eee2<<endl;
            toId = atoi(eee2.c_str());
            int c = (int)eee.length() + (int)eee2.length() + 4;
            //    cout<<c<<endl;
            string eee3 = getpos(c, yy);
            //  cout<<eee3<<endl;
            eLabel = atoi(eee3.c_str());
            boost::add_edge(fromId, toId, EdgeProperties(compide, eLabel), dataG.back());
            compide++;
        } break;
        }
    }

    return dataG;
}