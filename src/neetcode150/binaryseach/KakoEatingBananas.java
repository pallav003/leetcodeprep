package neetcode150.binaryseach;

import java.util.Arrays;

/**
 * Koko Eating Bananas
 * You are given an integer array piles where piles[i] is the number of bananas in
 * the ith pile. You are also given an integer h, which represents the number of
 * hours you have to eat all the bananas.
 * <p>
 * You may decide your bananas-per-hour eating rate of k. Each hour,
 * you may choose a pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, you may finish eating the pile but
 * you can not eat from another pile in the same hour.
 * <p>
 * Return the minimum integer k such that you can eat all the bananas within h hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [1,4,3,2], h = 9
 * <p>
 * Output: 2
 * Explanation: With an eating rate of 2, you can eat the bananas in 6 hours.
 * With an eating rate of 1, you would need 10 hours to eat all the bananas
 * (which exceeds h=9), thus the minimum eating rate is 2.
 */
public class KakoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean canEatAll(int[] piles, int h, int mid) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += pile / mid; // Equivalent to Math.ceil(pile / k)
            if (pile % mid != 0) {
                hoursNeeded++;
            }
            if (hoursNeeded > h) return false; // Early exit if exceeded
        }
        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        KakoEatingBananas kakoEatingBananas = new KakoEatingBananas();
        System.out.println(kakoEatingBananas.minEatingSpeed(new int[]{25, 10, 23, 4}, 4));
    }

}
