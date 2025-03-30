package neetcode150.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Number of Connected Components in an Undirected Graph
 * There is an undirected graph with n nodes. There is also an edges array,
 * where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
 * <p>
 * The nodes are numbered from 0 to n - 1.
 * <p>
 * Return the total number of connected components in that graph.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * n=3
 * edges=[[0,1], [0,2]]
 * <p>
 * Output:
 * 1
 * Example 2:
 * <p>
 * Input:
 * n=6
 * edges=[[0,1], [1,2], [2,3], [4,5]]
 * <p>
 * Output:
 * 2
 * Constraints:
 * <p>
 * 1 <= n <= 100
 * 0 <= edges.length <= n * (n - 1) / 2
 */
public class ConnectedComponent {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int output = 0;
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                output++;
                dfs(i, adjacencyList, visited);
            }

        }
        return output;
    }

    private void dfs(int i, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[i] = true;
        for (int node : adjacencyList.get(i)) {
            if (visited[node]) continue;
            dfs(node, adjacencyList, visited);
        }
    }
}
