package array;

public class No747 {
    private static final int[] nums = {1, 2, 3, 4};
    public static void main(String[] args) {
        int answer = dominantIndex(nums);
        System.out.println(answer);
    }

    private static int dominantIndex(int[] nums) {
        int maxOne = 0;
        int maxTwo = 0;
        int maxIdx = 0;

        for (int i=0; i < nums.length; i++) {
            if (nums[i] > maxOne) {
                maxTwo = maxOne;
                maxOne = nums[i];
                maxIdx = i;
            } else if (nums[i] > maxTwo) {
                maxTwo = nums[i];
            }
        }

        if (maxOne >= maxTwo * 2) return maxIdx;
        return -1;
    }
}
