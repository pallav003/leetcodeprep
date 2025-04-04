package neetcode150.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Redundant Connection
 * You are given a connected undirected graph with n nodes labeled
 * from 1 to n. Initially, it contained no cycles and consisted of n-1 edges.
 * <p>
 * We have now added one additional edge to the graph. The edge has two
 * different vertices chosen from 1 to n, and was not an edge that previously existed in the graph.
 * <p>
 * The graph is represented as an array edges of length n where
 * edges[i] = [ai, bi] represents an edge between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the graph is still a connected
 * non-cyclical graph. If there are multiple answers, return the edge that appears last in
 * the input edges.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[1,2],[1,3],[3,4],[2,4]]
 * <p>
 * Output: [2,4]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[1,2],[1,3],[1,4],[3,4],[4,5]]
 * <p>
 * Output: [3,4]
 * Constraints:
 * <p>
 * n == edges.length
 * 3 <= n <= 100
 * 1 <= edges[i][0] < edges[i][1] <= edges.length
 * There are no repeated edges and no self-loops in the input.
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        //solution pending
    return new int[] {};
    }
}
