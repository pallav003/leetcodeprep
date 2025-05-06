package array;

public class SortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums[0] >= 0) {
            int[] output = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                output[i] = nums[i] * nums[i];
            }
            return output;
        }
        int splitIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                splitIdx = i-1;
                break;
            }
        }
        if (splitIdx == -1) {
            splitIdx = nums.length-1;
        }

        System.out.println(splitIdx);

        int[] copyArr = new int[nums.length];
        int secondArrIdx = splitIdx + 1;
        int currIndex = 0;
        while (splitIdx >= 0 && secondArrIdx < nums.length) {
            if (Math.abs(nums[splitIdx]) < nums[secondArrIdx]) {
                copyArr[currIndex] = nums[splitIdx];
                splitIdx--;
            } else {
                copyArr[currIndex] = nums[secondArrIdx];
                secondArrIdx++;
            }
            currIndex++;
        }

        while (splitIdx >= 0) {
            copyArr[currIndex] = nums[splitIdx];
            splitIdx--;
            currIndex++;
        }
        while (secondArrIdx < nums.length) {
            copyArr[currIndex] = nums[secondArrIdx];
            secondArrIdx++;
            currIndex++;
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = copyArr[i] * copyArr[i];
        }
        return output;
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();
        int []output = sortedArray.sortedSquares(new int[]{-5,-3,-2,-1});
        for(int i : output) {
            System.out.print(i+" ");
        }
    }
}
