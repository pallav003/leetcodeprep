package neetcode150.linkedlist;

/**
 * Merge K Sorted Linked Lists
 * Solved
 * You are given an array of k linked lists lists, where each list is sorted in ascending order.
 * <p>
 * Return the sorted linked list that is the result of merging all of the individual linked lists.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,2,4],[1,3,5],[3,6]]
 * <p>
 * Output: [1,1,2,3,3,4,5,6]
 */
public class MergeKSortedLL {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = null;
        for (int i = 0; i < lists.length; i++) {
            output = mergeTwoLists(output, lists[i]);
        }
        return output;

    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (first != null && second != null) {
            if (first.val > second.val) {
                node.next = second;
                second = second.next;
            } else {
                node.next = first;
                first = first.next;
            }
            node = node.next;
        }
        while (first != null) {
            node.next = first;
            first = first.next;
            node = node.next;
        }
        while (second != null) {
            node.next = second;
            second = second.next;
            node = node.next;
        }
        return dummy.next;
    }
}
