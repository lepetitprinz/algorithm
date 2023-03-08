package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No1051 {
    private static final int[] heights = {1,1,4,2,1,3};

    public static void main(String[] args) {
        int answer = solution(heights);
        System.out.println(answer);
    }

    private static int solution(int[] heights) {
        int[] sorted_heights= Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted_heights);

        int count = 0;
        for (int i=0; i < heights.length; i++) {
            if (heights[i] != sorted_heights[i])
                count++;
        }

        return count;
    }

    private static int solution2(int[] heights) {
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for (int height : heights) {
            sorted.add(height);
        }

        int count = 0;
        for (int height: heights) {
            if (height != sorted.remove())
                count++;
        }

        return count;
    }
}
