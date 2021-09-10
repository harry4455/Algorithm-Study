/*
 * # 짝지어 삭제하기
 *
 *
 */
package PG.Level2;

import java.util.Stack;

public class pairAndDelete {
    public static void main(String[] args) {
        String s = "baabaa";
        solution(s);
    }

    public static int solution(String s) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String lastVal = stack.peek();
                String currVal = String.valueOf(s.charAt(i));
                if(!lastVal.equals(currVal)) {
                    stack.push(currVal);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
