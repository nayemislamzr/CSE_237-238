import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Vanilla BFS
 * Author : MD. Nayem Islam
 * Reg : 2019331092
 */

public class BFS {
    public ArrayList<ArrayList<Integer>> graph;
    public boolean[] visited;

    BFS(int nodes) {
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[nodes + 1];
        for (int i = 0; i <= nodes; i++)
            graph.add(new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
    }

    public void doBfs(int src) {
        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int currNode = q.poll();
            visited[currNode] = true;
            System.out.print(currNode + " ");
            for (int child : graph.get(currNode)) {
                if (!visited[child])
                    q.add(child);
            }
        }
    }

    public static void main(String[] args) {
        int nodes, edges, src;
        Scanner scanner = new Scanner(System.in);
        nodes = scanner.nextInt();
        edges = scanner.nextInt();
        BFS bfs = new BFS(nodes);
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

/**
 * Testcase :
 * 4
 * 3
 * 2 1
 * 2 3
 * 3 4
 * 2
 * 
 * Output :
 * 2 1 3 4
 */