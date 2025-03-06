package arrayproblems;

import java.util.*;
import java.util.stream.StreamSupport;

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
