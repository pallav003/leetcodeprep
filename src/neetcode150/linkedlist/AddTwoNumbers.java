package neetcode150.linkedlist;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
 * <p>
 * The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
 * <p>
 * Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Return the sum of the two numbers as a linked list.
 * <p>
 * Example 1:
 * Input: l1 = [1,2,3], l2 = [4,5,6]
 * <p>
 * Output: [5,7,9]
 * <p>
 * Explanation: 321 + 654 = 975.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode output = new ListNode(0);
        ListNode finalOutput = output;
        while (l1 != null || l2!= null || carry!= 0) {
            int sum = carry;
            if(l1!= null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum+= l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            output.next = new ListNode(sum);
            output = output.next;
        }
        return finalOutput.next;
    }



    public static void main(String[] args) {
        AddTwoNumbers twoNumbers = new AddTwoNumbers();
        ListNode listNode = new ListNode(9);

        ListNode output = twoNumbers.addTwoNumbers(listNode,listNode);

        while (output!= null) {
            System.out.print(output.val+" ");
            output = output.next;
        }
    }

}
