package neetcode150.graph;

import java.util.*;

/**
 * Graph Valid Tree
 * Given n nodes labeled from 0 to n - 1 and a list of undirected
 * edges (each edge is a pair of nodes), write a function to check
 * whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * n = 5
 * edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
 * <p>
 * Output:
 * true
 * Example 2:
 * <p>
 * Input:
 * n = 5
 * edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
 * <p>
 * Output:
 * false
 * Note:
 * <p>
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and
 * thus will not appear together in edges.
 * Constraints:
 * <p>
 * 1 <= n <= 100
 * 0 <= edges.length <= n * (n - 1) / 2
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, visited, adj)) {
            return false;
        }

        return visited.size() == n;

    }

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adj) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) continue;
            if (!dfs(nei, node, visited, adj)) {
                return false;
            }
        }
        return true;
    }
}
