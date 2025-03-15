package neetcode150.arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNonDuplicate {
    public List<Integer> getNonDuplicateElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }

        }
        return list;

    }

    public static void main(String[] args) {

        FindNonDuplicate findNonDuplicate = new FindNonDuplicate();
        int[] arr = {7, 4, 5, 7, 5};
        /**
         * 7 -> 7 -> 1
         * 4 -> 4 -> 1
         * 5 -> 5 -> 1
         * 7 -> 7 -> 2
         * 5 -> 5 -> 2
         */
        System.out.println(findNonDuplicate.getNonDuplicateElements(arr));
    }
}
