package dp;

import java.util.ArrayList;
import java.util.List;

/*
 * 118. Pascal's Triangle
 */
public class No118 {
    private static final int numRows = 5;
    public static void main(String[] args) {
        List<List<Integer>> answer = generatePascal(numRows);
        System.out.println(answer);
    }
    private static List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        answer.add(first);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = answer.get(i - 1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(prev.get(j) + prev.get(j + 1));
            }
            temp.add(1);
            answer.add(temp);
        }
        return answer;
    }
}
