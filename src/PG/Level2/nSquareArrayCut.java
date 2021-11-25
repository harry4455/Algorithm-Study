/*
 * # n^2 배열 자르기
 *
 */
package PG.Level2;

import java.util.Arrays;

public class nSquareArrayCut {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right= 5;

        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) (Math.max(Math.floor(left / n), left % n) + 1);
            left++;
        }

        return answer;
    }
}
