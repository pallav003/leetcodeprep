package neetcode150.windowsliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
 * <p>
 * You may assume that the correct output is always unique.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "OUZODYXAZV", t = "XYZ"
 * <p>
 * Output: "YXAZ"
 * Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
 */
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int matched = 0;
        int start = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if (freqMap.containsKey(c)
                    && freqMap.get(c) == windowFreq.get(c)) {
                matched++;
            }

            while (matched == freqMap.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (freqMap.containsKey(leftChar)
                        && windowFreq.get(leftChar) < freqMap.get(leftChar)) {
                    matched--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
    }
}
