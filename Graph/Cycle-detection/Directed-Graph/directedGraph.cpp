#include <bits/stdc++.h>
using namespace std;

/**
 * Tutorial Link :
 *  https://www.youtube.com/watch?v=0dJmTuMrUZM
 */

vector<bool> visited;
vector<int> *graph;

ostream &operator<<(ostream &os, const vector<bool> &visited)
{
    for (int i = 0; i < visited.size(); i++)
        os << visited[i] << ' ';
    os << '\n';
    return os;
}

bool isCyclicUtil(int node)
{
    if (visited[node])
        return true;
    visited[node] = true;
    for (auto &adj : graph[node])
    {
        if (isCyclicUtil(adj))
            return true;
    }
    visited[node] = false;
    return false;
}

bool iscyclic(int nodes)
{
    for (int i = 0; i < nodes; i++)
    {
        if (isCyclicUtil(i))
            return true;
    }
    return false;
}

int main()
{
    int nodes, edges;
    cin >> nodes >> edges;
    visited.resize(nodes, false);
    graph = new vector<int>[nodes];
    for (int i = 0; i < edges; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
    }
    if (iscyclic(nodes))
        cout << "YES\n";
    else
        cout << "NO\n";
}