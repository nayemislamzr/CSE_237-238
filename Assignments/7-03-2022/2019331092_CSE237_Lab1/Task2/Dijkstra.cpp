#include <iostream>
#include <vector>
#include <queue>

/*
    Dijstra Algorithm in a directed graph
    Author : MD. Nayem Islam

    - Single source shortest path algo
    - Uses gready method
    - Does not work with negative weighted graph

    How does this work:
    Always selects the vertex with the shortest path then it update the shortest 
    path to other vertices if possible. This updation is called relaxation

    Relaxation :
    dis[v] = min(dis[v],dis[u]+ cost(u,v));

    Time complexity :
    0(|v|*|v|) = 0(n*n)
    with fibonacci heap 0(V+ElogV)
*/
#define total_vertices 6
#define total_edges 8
bool visited[total_vertices] = {false};
std::vector<int> distance(total_vertices, INT16_MAX);

int dijkstra(std::vector<std::vector<int>> &graph, int src, int dest)
{
    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
    distance[src] = 0;
    pq.push({0, src});
    while (!pq.empty())
    {
        std::pair<int, int> top_elem = pq.top();
        pq.pop();
        if (visited[top_elem.second])
            continue;
        visited[top_elem.second] = true;
        for (int i = 0; i < total_vertices; i++)
        {
            if (graph[top_elem.second][i] != -1 && top_elem.first + graph[top_elem.second][i] < distance[i])
            {
                distance[i] = top_elem.first + graph[top_elem.second][i];
                pq.push({distance[i], i});
            }
        }
    }
    return distance[dest];
}

int main()
{
    std::vector<std::vector<int>> graph = {
        {-1, 2, 4, -1, -1, -1},
        {-1, -1, 1, 7, -1, -1},
        {-1, -1, -1, -1, 3, -1},
        {-1, -1, -1, -1, -1, 1},
        {-1, -1, -1, 2, -1, 5},
        {-1, -1, -1, -1, -1, -1}};
    const int src = 0, dest = 5;
    std::cout << "The shortest path from node " << src << " to " << dest << " is : " << dijkstra(graph, 0, 5) << '\n';
}