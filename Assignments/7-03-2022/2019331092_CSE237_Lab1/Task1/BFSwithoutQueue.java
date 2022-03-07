import java.util.ArrayList;
import java.util.Scanner;

/**
 * BFS without using Queue DataStructure
 * Author : MD. Nayem Islam
 * Reg : 2019331092
 */

public class BFSwithoutQueue {
    public ArrayList<ArrayList<Integer>> graph;
    public boolean[] visited;
    public int[] distance;

    BFSwithoutQueue(int nodes) {
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[nodes + 1];
        distance = new int[nodes + 1];
        for (int i = 0; i <= nodes; i++)
            visited[i] = false;
        for (int i = 0; i <= nodes; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i <= nodes; i++)
            distance[i] = Integer.MAX_VALUE;
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
    }

    public void doBfs(int src) {
        ArrayList<Integer> visitArray = new ArrayList<>();
        visitArray.add(src);
        distance[src] = 0;
        int index = 0;
        while (index < visitArray.size()) {
            int currNode = visitArray.get(index);
            for (int child : graph.get(currNode)) {
                if (!visited[child]) {
                    visited[child] = true;
                    distance[child] = distance[currNode] + 1;
                    visitArray.add(child);
                }
            }
            index++;
        }
        for (int node : visitArray)
            System.out.print(node + " ");
    }

    public static void main(String[] args) {
        int nodes, edges, src;
        Scanner scanner = new Scanner(System.in);
        nodes = scanner.nextInt();
        edges = scanner.nextInt();
        BFSwithoutQueue bfs = new BFSwithoutQueue(nodes);
        for (int i = 0; i < edges; i++) {
            int from, to;
            from = scanner.nextInt();
            to = scanner.nextInt();
            bfs.addEdge(from, to);
        }
        src = scanner.nextInt();
        scanner.close();
        bfs.doBfs(src);
    }
}

/*
 * TestCase :
 * 6
 * 5
 * 2 1
 * 2 3
 * 3 4
 * 3 5
 * 1 6
 * 2
 * 
 * Output :
 * 2 1 3 6 4 5
 */
