/*
 * # 주식가격
 *
 * stack을 이용해서 풀이.
 *
 */

package PG.Level2;

import java.util.Arrays;
import java.util.Stack;

public class stockPrice {
    public static void main(String[] args) {
        //int[] prices = {1,2,3,2,3};
        int[] prices = {1,2,4,2,3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
