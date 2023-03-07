package array;

import java.util.Arrays;

public class No905 {
    private static final int[] nums = {3, 1, 2, 4};

    public static void main(String[] args) {
        int[] answer = solution(nums);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] nums) {
        int pointer = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[pointer];
                nums[pointer++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
