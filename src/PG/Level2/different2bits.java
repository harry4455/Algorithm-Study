/*
 * # 2개 이하로 다른 비트
 *
 *
 */
package PG.Level2;

import java.util.Arrays;

public class different2bits {
    public static void main(String[] args) {
        long[] numbers = {2,7};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();

        for(int i=0; i<numbers.length; i++) {
            answer[i]++;

            System.out.println("answer : " + answer[i]);
            System.out.println("numbers : " + numbers[i]);
            System.out.println("CHK : " + (answer[i] ^ numbers[i]));

            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }

        return answer;
    }
}
