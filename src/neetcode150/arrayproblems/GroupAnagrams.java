package neetcode150.arrayproblems;

import java.util.*;

/**
 * Group Anagrams
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 *
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> outputMap = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String arrStr = Arrays.toString(arr);
            List<String> list = outputMap.getOrDefault(arrStr, new ArrayList<>());
            list.add(str);
            outputMap.put(arrStr, list);
        }

        return new ArrayList<>(outputMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(strs);

    }
}
