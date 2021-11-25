/*
 * # 이진 변환 반복하기
 *
 */

package PG.Level2;

import java.util.Arrays;

public class binaryRepeat {
    public static void main(String[] args) {
        String s = "110010101001";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            answer[0]++;    // 2진 연산되는 횟수
            String tmp = s.replace("0", "");
            answer[1] += s.length() - tmp.length(); // 사라진 0의 갯수
            s = Integer.toBinaryString(tmp.length()).toString();
        }


        return answer;
    }
}
