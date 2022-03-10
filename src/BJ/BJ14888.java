/**
 * #BJ14888
 *
 * 연산자 끼워넣기
 *
 */

package BJ;

import java.util.Scanner;

public class BJ14888 {
    static int N, max, min;
    static int[] nums, operators, order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];

        for(int i=1; i<=N; i++) nums[i] = sc.nextInt();
        for(int i=1; i<=4; i++) operators[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        rec_func(1, nums[1]);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

    }

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2){
        // nums, order
        if(operator == 1) {
            return operand1 + operand2;
        } else if(operator == 2){
            return operand1 - operand2;
        } else if(operator == 3){
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장
    private static void rec_func(int k, int value) {
        if(k == N) {
            // 완성된 식에 맞게 계산을 해서 정답을 갱신
//            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);

            // value를 정답에 갱싢
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for(int cand = 1; cand <= 4; cand++) {
                if(operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                    order[k] = 0;
                }
            }

            // 4가지 연산자들 중 뭘 쓸 것인지 선택하고 연산자를 계산한 후에 재귀호출

        }
    }
}
