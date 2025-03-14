package windowsliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Repeating Character Replacement
 * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
 * <p>
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "XYYX", k = 2
 * <p>
 * Output: 4
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int output = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));

            while (right - left + 1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            output = Math.max(right - left + 1, output);
        }
        return output;
    }
}
