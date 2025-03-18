package neetcode150.linkedlist;

/**
 * Reverse Linked List
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [0,1,2,3]
 * <p>
 * Output: [3,2,1,0]
 * Example 2:
 * <p>
 * Input: head = []
 * <p>
 * Output: []
 * Constraints:
 * <p>
 * 0 <= The length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}