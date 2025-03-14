package windowsliding;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "zxyzxyz"
 * <p>
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characterSet = new HashSet<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(s.charAt(right));
            result = Math.max(result, right - left + 1);


        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new
                LongestSubstring();
        System.out.print(longestSubstring.lengthOfLongestSubstring("pkkkew"));
    }
}
