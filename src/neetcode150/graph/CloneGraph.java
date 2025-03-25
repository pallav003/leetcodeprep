package neetcode150.graph;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clone Graph
 * Solved
 * Given a node in a connected undirected graph, return a deep copy of the graph.
 * <p>
 * Each node in the graph contains an integer value and a list of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * The graph is shown in the test cases as an adjacency list. An adjacency list is a mapping of nodes to lists, used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * <p>
 * For simplicity, nodes values are numbered from 1 to n, where n is the total number of nodes in the graph. The index of each node within the adjacency list is the same as the node's value (1-indexed).
 * <p>
 * The input node will always be the first node in the graph and have 1 as the value.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: adjList = [[2],[1,3],[2]]
 * <p>
 * Output: [[2],[1,3],[2]]
 * Explanation: There are 3 nodes in the graph.
 * Node 1: val = 1 and neighbors = [2].
 * Node 2: val = 2 and neighbors = [1, 3].
 * Node 3: val = 3 and neighbors = [2].
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: adjList = [[]]
 * <p>
 * Output: [[]]
 * Explanation: The graph has one node with no neighbors.
 * <p>
 * Example 3:
 * <p>
 * Input: adjList = []
 * <p>
 * Output: []
 * Explanation: The graph is empty.
 * <p>
 * Constraints:
 * <p>
 * 0 <= The number of nodes in the graph <= 100.
 * 1 <= Node.val <= 100
 * There are no duplicate edges and no self-loops in the graph.
 */
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(oldToNew, node);
    }

    public Node dfs(Map<Node, Node> oldToNew, Node node) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(dfs(oldToNew, neighbour));
        }
        return copy;
    }

}

