package twopointers;

/**
 *
 * Valid Palindrome
 * Solved
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 *
 * Output: true
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll(
                "[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
