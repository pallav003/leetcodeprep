package neetcode150.arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * The test cases are generated such that the answer is always unique.
 *
 * You may return the output in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,3], k = 2
 *
 * Output: [2,3]
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i,0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets [freq] == null) {
                buckets [freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && list.size()<k ; i--) {
            if (buckets[i] != null) {
                list.addAll(buckets[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int [] arr = {1,2,2,3,3,3};
        int [] output = topKFrequent.topKFrequent(arr, 2);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
