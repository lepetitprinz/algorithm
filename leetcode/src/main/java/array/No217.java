package array;

import java.util.HashSet;

/*
 * Example list
 * nums = [1,2,3,1] -> true
 * nums = [1,2,3,4] -> false
 * nums = [1,1,1,3,3,4,3,2,4,2] -> true
 */

public class No217 {
    private static final int[] nums = new int[] {1, 2, 3, 1};
    public static void main(String[] args) {
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> history = new HashSet<>();
        for (int num : nums) {
            if (history.contains(num)) {
                return true;
            } else {
                history.add(num);
            }
        }

        return false;
    }
}
