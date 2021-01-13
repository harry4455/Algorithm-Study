package PG;

import java.util.Arrays;
import java.util.Stack;
// 효율성에서 에러
// https://codevang.tistory.com/313

public class Solution305 {

    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        /*int[] answer = new int[prices.length];

        for(int i=0; i<answer.length; i++) {
            int cnt = 0;
            int val = prices[i];
            Stack<Integer> stack = new Stack<Integer>();
            for(int j=prices.length-1; j>=i+1; j--){
                stack.add(prices[j]);
            }
            int size = stack.size();
            for(int k=0; k<size; k++){
                cnt++;
                if(val > stack.pop()){
                    cnt++;
                    answer[i] = cnt;
                    break;
                }
                answer[i] = cnt;
            }
        }
        return answer;*/

        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        // 뒤에서부터 순회
        for (int i = prices.length - 2; i >= 0; i--) {

            // 앞쪽의 숫자가 뒷쪽의 숫자보다 클 경우
            if (prices[i] > prices[i + 1]) {

                answer[i] = 1;
                stack.push(new int[]{prices[i + 1], i + 1});

                // 앞쪽의 숫자가 뒷쪽의 숫자보다 작거나 같은 경우
            } else {

                // 스택에서 자신보다 낮은 값이 나올때까지 모두 지워줌
                while (stack.size() > 0 && stack.peek()[0] >= prices[i]) {
                    stack.pop();
                }

                // 스택이 빌 경우 (뒷쪽의 모든 값이 자신보다 큼)
                if (stack.size() == 0) {
                    answer[i] = prices.length - i - 1;

                    // 스택에 자신보다 낮은 숫자가 남아있다면 해당 인덱스와 자신의 인덱스를 이용해 계산
                } else {
                    answer[i] = stack.peek()[1] - i;
                }
            }
        }

        return answer;


    }
}
