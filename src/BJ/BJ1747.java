/*
    #1747 소수&팰린드롬

    숫자 N의 범위 때문에, 시간 복잡도를 잘 고려해야함.
    따라서 소수를 판별하는 decimalChk에서 에라토스테네스의 체를 활용하여 제곱근 시간 계산을 활용

    이후에 Stack에 숫자를 문자로 하나씩 집어넣어 비교하고, 최종적으로 stack이 비게 되면 결과 성공.
 */

package BJ;

import java.util.Scanner;
import java.util.Stack;

public class BJ1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        for(int i=n; ; i++) {
            boolean decimalChk = decimal(i);
            if(decimalChk) {
                boolean reverseChk = reverse(i);
                if(reverseChk) {
                    answer = i;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean reverse(int num) {
        boolean flag = false;
        Stack<Character> stack = new Stack<Character>();
        if(num >= 1 && num <= 9) {
            flag = true;
            return flag;
        }

        String str = num + "";
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(i < str.length()/2)
                stack.push(ch);
            else{
                if(str.length()%2 != 0 && i == str.length()/2) continue;
                if(stack.peek() == ch) stack.pop();
            }
        }

        if(stack.isEmpty()){
            flag = true;
        }

        return flag;
    }

    private static boolean decimal(int num) {
        if(num < 2) {
            return false;
        }

        for(int i=2; i*i <= num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
