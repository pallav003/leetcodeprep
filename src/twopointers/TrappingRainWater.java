package twopointers;

/**
 * Trapping Rain Water
 * You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
 * <p>
 * Return the maximum area of water that can be trapped between the bars.
 * <p>
 * Input: height = [0,2,0,3,1,0,1,3,2,1]
 * <p>
 * Output: 9
 */

public class TrappingRainWater {

    public int trap(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        // lMax : Maximum in subarray arr[0..left-1]
        // rMax : Maximum in subarray arr[right+1..n-1]
        int lMax = arr[left - 1];
        int rMax = arr[right + 1];

        int res = 0;
        while (left <= right) {

            // If rMax is smaller, then we can decide the amount of water for arr[right]
            if (rMax <= lMax) {

                // Add the water for arr[right]
                res += Math.max(0, rMax - arr[right]);

                // Update right max
                rMax = Math.max(rMax, arr[right]);

                // Update right pointer as we have decided the amount of water for this
                right -= 1;
            } else {

                // Add the water for arr[left]
                res += Math.max(0, lMax - arr[left]);

                // Update left max
                lMax = Math.max(lMax, arr[left]);

                // Update left pointer as we have decided water for this
                left += 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.print(trappingRainWater.trap(arr));
    }
}
