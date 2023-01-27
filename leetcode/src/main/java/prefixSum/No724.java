package prefixSum;

import java.util.Arrays;

/*
 724. Find Pivot Index

 input example:
 - nums = {1, 2, 3}
 - nums = {0}
 - nums = {-1, 0, 1}
 - nums = {-1, -1, 0, 1, 1}

 */
public class No724 {
    private static final int[] nums = {1, 7, 3, 6, 5, 6};

    public static void main(String[] args) {
        int result = pivotIndex(nums);
        System.out.println(result);
    }

    private static int pivotIndex(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).sum();
        for (int i=0; i < nums.length; i++) {
            int num = nums[i];
            right -= num;
            if (left == right) return i;
            left += num;
        }
        return -1;
    }
}
