package neetcode150.binaryseach;

/**
 * Median of Two Sorted Arrays
 * You are given two integer arrays nums1 and nums2 of size m and n respectively,
 * where each is sorted in ascending order. Return the median value among all elements
 * of the two arrays.
 * <p>
 * Your solution must run in
 * O
 * (
 * l
 * o
 * g
 * (
 * m
 * +
 * n
 * )
 * )
 * O(log(m+n)) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3]
 * <p>
 * Output: 2.0
 * Explanation: Among [1, 2, 3] the median is 2.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = ((n1 + n2 + 1) / 2) - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            /**
             * suppose in case 1,2,5 and 3,4,6,7
             * 1,2    5
             * 3      4,6,7
             *
             *
             */
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }

        }
        return 0;
    }
}
