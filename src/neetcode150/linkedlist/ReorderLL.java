package neetcode150.linkedlist;

/**
 * Reorder Linked List
 * You are given the head of a singly linked-list.
 * <p>
 * The positions of a linked list of length = 7 for example, can intially be represented as:
 * <p>
 * [0, 1, 2, 3, 4, 5, 6]
 * <p>
 * Reorder the nodes of the linked list to be in the following order:
 * <p>
 * [0, 6, 1, 5, 2, 4, 3]
 * <p>
 * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
 * <p>
 * [0, n-1, 1, n-2, 2, n-3, ...]
 * <p>
 * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [2,4,6,8]
 * <p>
 * Output: [2,8,4,6]
 * Example 2:
 * <p>
 * Input: head = [2,4,6,8,10]
 * <p>
 * Output: [2,10,4,8,6]
 */
public class ReorderLL {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverseList(secondHalf);
        ListNode firstHalf = head;
        while(firstHalf!= null && secondHalf!= null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            if (temp1 == null) break;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private ListNode reverseList(ListNode secondHalf) {
        ListNode prev = null, curr = secondHalf, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
