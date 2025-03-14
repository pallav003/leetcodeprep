package windowsliding;

import java.util.Arrays;

/**
 * Permutation in String
 * You are given two strings s1 and s2.
 * <p>
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 * <p>
 * Both strings only contain lowercase letters.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "abc", s2 = "lecabee"
 * <p>
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a'] += 1;
            arr2[s2.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        int left = 0;
        int right = s1.length();
        for (; right < s2.length(); right++) {
            arr2[s2.charAt(left) - 'a'] -= 1;
            arr2[s2.charAt(right) - 'a'] += 1;
            left++;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString ps = new PermutationInString();
        System.out.print(ps.checkInclusion("abc", "lecabee"));
    }
}
