package neetcode150.linkedlist;

/**
 * Remove Node From End of Linked List
 * Solved
 * You are given the beginning of a linked list head, and an integer n.
 * <p>
 * Remove the nth node from the end of the list and return the beginning of the list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4], n = 2
 * <p>
 * Output: [1,2,4]
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for (int i = 0; i <= n; i++) {
            if (first == null) return head; // Handles cases where n > length (shouldn't occur in valid input)
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;


    }
}
