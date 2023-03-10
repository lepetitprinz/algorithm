package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class No414 {
    private static final int[] nums = {2, 2, 3, 1};
    public static void main(String[] args) {
        int answer = solution(nums);
        System.out.println(answer);
    }

    private static int solution(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numsList.sort(Collections.reverseOrder());

        int count = 1;
        int prev = numsList.get(0);
        for (int i=1; i < nums.length; i++) {
            int temp = numsList.get(i);
            if (temp != prev) {
                prev = temp;
                count++;
            }
            if (count == 3) return prev;
        }

        return Collections.max(numsList);
    }

    private static int solution2(int[] nums) {
        long fstMax = Long.MIN_VALUE;
        long secMax = Long.MIN_VALUE;
        long thiMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == fstMax || num == secMax || num == thiMax) continue;
            if (num >= fstMax) {
                thiMax = secMax;
                secMax = fstMax;
                fstMax = num;
            } else if (num >= secMax) {
                thiMax = secMax;
                secMax = num;
            } else if (num >= thiMax) {
                thiMax = num;
            }
        }

        long answer = thiMax;
        if (answer == Long.MIN_VALUE) return (int)fstMax;
        return (int)answer;
    }
}
