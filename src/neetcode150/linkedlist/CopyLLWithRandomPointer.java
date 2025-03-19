package neetcode150.linkedlist;

/**
 * Copy Linked List with Random Pointer
 * You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
 * <p>
 * Create a deep copy of the list.
 * <p>
 * The deep copy should consist of exactly n new nodes, each including:
 * <p>
 * The original value val of the copied node
 * A next pointer to the new node corresponding to the next pointer of the original node
 * A random pointer to the new node corresponding to the random pointer of the original node
 * Note: None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
 * <p>
 * Input: head = [[3,null],[7,3],[4,0],[5,1]]
 * <p>
 * Output: [[3,null],[7,3],[4,0],[5,1]]
 */
public class CopyLLWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;

        // Step 1: Clone nodes and insert them next to original nodes
        while (current != null) {
            Node cloned = new Node(current.val);
            cloned.next = current.next;
            current.next = cloned;
            current = cloned.next;
        }
        // Step 2: Copy random pointers

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Detach the cloned list from the original list
        current = head;
        Node newHead = head.next;
        Node copy = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            current = current.next;
            copy = copy.next;
        }
        return newHead;


    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
