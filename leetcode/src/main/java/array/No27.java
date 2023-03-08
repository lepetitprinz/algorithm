package array;

public class No27 {
    private static final int[] nums = {0,1,2,2,3,0,4,2};
    private static final int val = 2;

    public static void main(String[] args) {
        int answer = solution(nums, val);
        System.out.println(answer);
    }
    private static int solution(int[] nums, int val) {
        int pointer=0;
        for (int num: nums) {
            if (num != val) {
                nums[pointer++] = num;
            }
        }

        return pointer;
    }
}
