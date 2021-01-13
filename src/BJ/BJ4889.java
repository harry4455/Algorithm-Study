package BJ;/*
    #4889 안정적인 문자열
    스택을 활용하여 문제 풀이 진행
    
    첫번째 풀이는 아마 loop 돌때 범위를 제대로 안정해서 일듯
    두번째 풀이는 그냥 while 문 돌려서 했는데 원리는 비슷
    
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BJ4889 {
    /*
    // 첫번째 풀이
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; ; i++) {
            char[] ch = br.readLine().toCharArray();
            int answer = 0;
            stack = new Stack<Character>();

            if (ch[0] == '-') {
                break;
            }
            for (int j = 0; j < ch.length; j++) {
                // 스택 안에 여는 괄호 없이 닫는 괄호 등장하면 치환해서 스택에 더하고 값 증가
                if (stack.isEmpty() && ch[i] == '}') {
                    stack.add('{');
                    answer++;
                // 스택이 채워져 있고 닫는 괄호가 나오면 스택 pop 하고 정리
                } else if (ch[i] == '}') {
                    stack.pop();
                // 그 외의 경우 여는 괄호 경우 뿐이니, 스택에 더해줌
                } else {
                    stack.add('{');
                }
            }

            // 결국 괄호 만들어주면 되니까 스택안에 여는 괄호 중 절반을 닫는 괄호로 치환
            // 그 만큼의 변환 횟수가 발생
            answer += stack.size() / 2;
            sb.append(i).append(". ").append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }*/
    
    // 두 번째 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int cnt = 0;
        while(!str.contains("-")) {
            cnt++;
            while(str.contains("{}")) {
                str = str.replaceAll("\\{\\}", "");
            }
            int a = 0;
            int b = 0;

            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    a++;
                } else {
                    b++;
                }
            }

            if(b%2 == 0) {
                System.out.println(cnt + ". " + ((a/2) + (b/2)));
            } else {
                System.out.println(cnt + ". " + ((a/2) + (b/2) + 2));
            }

            str = sc.nextLine();
        }
    }
}
