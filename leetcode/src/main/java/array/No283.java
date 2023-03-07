package array;


import java.util.Arrays;

/*
 283. Move Zeroes
 */
public class No283 {
    final static int[] nums = {0,1,0,3,12};
    public static void main(String[] args) {
        int[] answer = moveZeroes(nums);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] moveZeroes(int[] nums) {
        int writerPointer = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[writerPointer] = num;
                writerPointer++;
            }
        }

        for (int i=writerPointer; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
