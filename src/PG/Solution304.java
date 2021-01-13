package PG;// Stack으로 풀어내기는 해보기
// arraylist로 풀어내기

import java.util.ArrayList;

public class Solution304 {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        solution(arrangement);
    }

    public static int solution(String arrangement) {
        int answer = 0;

        String copyArr = arrangement.replace("()", "1"); // 괄호가 만나는 부분은 레이저가 됨으로 숫자로 치환

        // 새로운 ArrayList에 값을 쪼개어 넣어줌
        ArrayList<Character> arrList = new ArrayList<Character>();

        for (int i = 0; i < copyArr.length(); i++) {
            arrList.add(copyArr.charAt(i));
        }

        //
        ArrayList<Character> stack = new ArrayList<Character>();

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList);
            if (arrList.get(i) == '(') {
                stack.add(arrList.get(i));
            } else if (arrList.get(i) == ')') {
                System.out.println("STACK 1 " + stack);
                stack.remove(stack.size() - 1);
                System.out.println(stack);
                answer += 1;
            } else if (arrList.get(i) == '1') {
                answer += stack.size();
            }
        }
        return answer;
    }
}
