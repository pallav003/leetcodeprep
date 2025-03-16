package neetcode150.stack;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * Solved
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 * <p>
 * Return the integer that represents the evaluation of the expression.
 * <p>
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 * <p>
 * Input: tokens = ["1","2","+","3","*","4","-"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 1000.
 * tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") ||
                    s.equals("-") ||
                    s.equals("/") ||
                    s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0) {
                            stack.push(0);
                        } else {
                            stack.push(b / a);
                        }
                        break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
}
