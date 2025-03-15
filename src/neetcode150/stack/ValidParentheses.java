package neetcode150.stack;

import java.util.Stack;

/**
 * Valid Parentheses
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 * <p>
 * The input string s is valid if and only if:
 * <p>
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "[]"
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "([{}])"
 * <p>
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "[(])"
 * <p>
 * Output: false
 * Explanation: The brackets are not closed in the correct order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' ||
                    c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ')' && stack.pop() != '(') {
                    return false;
                } else if (c == '}' && stack.pop() != '{') {
                    return false;
                } else if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("["));
    }
}
