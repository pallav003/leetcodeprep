package neetcode150.linkedlist;

/**
 * Merge Two Sorted Linked Lists
 * Solved
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
 * <p>
 * The new list should be made up of nodes from list1 and list2.
 * <p>
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,5]
 * <p>
 * Output: [1,1,2,3,4,5]
 */
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode listNode = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                listNode.next = list2;
                list2 = list2.next;
            } else {
                listNode.next = list1;
                list1 = list1.next;
            }
            listNode = listNode.next;
        }
        while (list1 != null) {
            listNode.next = list1;
            list1 = list1.next;
            listNode = listNode.next;
        }

        while (list2 != null) {
            listNode.next = list2;
            list2 = list2.next;
            listNode = listNode.next;
        }
        return dummy.next;
    }
}
