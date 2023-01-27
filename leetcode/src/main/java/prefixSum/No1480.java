package prefixSum;

import java.util.Arrays;

/*
 1480. Running Sum of 1d Array
 */
public class No1480 {
    private static final int[] nums = {1,2,3,4};

    public static void main(String[] args) {
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
