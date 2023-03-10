package array;

import java.util.*;
import java.util.stream.Collectors;

public class No448 {
    static final int[] nums = {4,3,2,7,8,2,3,1};

    public static void main(String[] args) {
        List<Integer> answer = findDisappearedNumbers(nums);
        System.out.println(answer);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] res = new int[nums.length + 1];

        for (int num : nums) {
            res[num] = num;
        }

        List<Integer> result = new ArrayList<>(res.length);
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
