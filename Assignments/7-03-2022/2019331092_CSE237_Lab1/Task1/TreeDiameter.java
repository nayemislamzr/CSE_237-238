import java.util.ArrayList;
import java.util.Scanner;

/**
 * Diameter Of a Tree using DFS
 * Author : MD. Nayem Islam
 * Reg : 2019331092
 */

public class TreeDiameter {
    public ArrayList<ArrayList<Integer>> graph;
    public int[] distance;
    public int extreme;

    TreeDiameter(int nodes) {
        graph = new ArrayList<ArrayList<Integer>>();
        distance = new int[nodes + 1];
        extreme = 1;
        for (int i = 0; i <= nodes; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i <= nodes; i++)
            distance[i] = 0;
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
    }

    public void doDfs(int src, int parent) {
        for (int child : graph.get(src)) {
            if (child == parent)
                continue;
            distance[child] = distance[src] + 1;
            if (distance[child] >= distance[extreme])
                extreme = child;
            doDfs(child, src);
        }
    }

    public static void main(String[] args) {
        int nodes;
        Scanner scanner = new Scanner(System.in);
        nodes = scanner.nextInt();
        TreeDiameter td = new TreeDiameter(nodes);
        for (int i = 0; i < nodes - 1; i++) {
            int from, to;
            from = scanner.nextInt();
            to = scanner.nextInt();
            td.addEdge(from, to);
            td.addEdge(to, from);
        }
        scanner.close();
        int firstEnd, secondEnd;
        td.doDfs(1, 0);
        firstEnd = td.extreme;
        td.distance[td.extreme] = 0;
        td.doDfs(td.extreme, 0);
        secondEnd = td.extreme;
        System.out.println("The Tree has maximum length of " + (td.distance[td.extreme] + 1) + " from node " + firstEnd
                + " to " + secondEnd);
    }
}

/*
 * TestCase :
 * 6
 * 1 2
 * 2 4
 * 2 5
 * 1 3
 * 3 6
 * 
 * Output :
 * The Tree has maximum length of 5 from node 6 to 5
 */