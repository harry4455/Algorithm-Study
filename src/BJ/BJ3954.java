/*
    #3954 Brainf**k 인터프리터

    괄호 여닫고 왔다갔다 하는게 가장 복잡했던 부분

    해당 내용은 블로그 참고해서 포인터로 위치잡아 계산해나가는 방식을 택함.

 */

package BJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ3954 {
    static int m,c,i;
    static String program;
    static String input;
    static int pointerPos;
    static int inputPos;
    static int[] arr;
    static int[] bracket;
    static int pid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while(t-- > 0) {
            stk = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stk.nextToken());  //  메모리 크기
            c = Integer.parseInt(stk.nextToken());  //  코드 크기
            i = Integer.parseInt(stk.nextToken());  //  입력 크기

            program = br.readLine();
            input = br.readLine();

            arr = new int[m];
            pointerPos = 0; // 포인터가 가리키는 위치
            inputPos = 0;   // inputCode의 현재 입력받아야 하는 위치

            Stack<Integer> stack = new Stack<>();
            bracket = new int[c];   // 서로 연결되어 있는 괄호의 위치

            for(int i=0; i<c; i++) {
                char c = program.charAt(i);

                if(c == '[') {
                    stack.push(i);
                } else if(c == ']') {   // 닫는 괄호와 여는 괄호를 서로 연결
                    int tmp = stack.peek();
                    bracket[i] = tmp;   // 여는 괄호에는 닫는 괄호의 위치를
                    bracket[tmp] = i;   // 닫는 괄호에는 여는 괄호의 위치를 저장
                    stack.pop();
                }
            }

            pid = 0; // 특정 명령어를 읽은 위치
            int cnt = 0;    // 반복 횟수
            while(cnt <= 50000000 && pid < c) {
                ++cnt;
                doStep();
            }

            if(pid == c) {  // 해당 명령어를 모두 읽어드림
                ans.append("Terminates\n");
            } else {
                /* 도중에 무한 루프 발생
                    일단 50000000번만큼 이동한 위치를 기억해 둔 상태에서
                    50000000번만큼 다시 명령어를 읽어들임. 그때, 최대 위치가
                    닫는 괄호의 위치이고 최소 위치는 여는 괄호의 위치 -1
                 */

                int maxpid = pid;   // 닫는 괄호의 위치
                int minpid = pid;   // 여는 괄호의 위치

                while(cnt-- > 0) {
                    doStep();
                    maxpid = Math.max(maxpid, pid);
                    minpid = Math.min(minpid, pid);
                }
                ans.append("Loops " + (minpid - 1) + " " + maxpid + "\n");
            }
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doStep() {
        char c = program.charAt(pid);

        switch (c) {
            case '-':
                arr[pointerPos] = (arr[pointerPos] - 1) < 0 ? 255 : (arr[pointerPos] - 1);
                break;
            case '+':
                arr[pointerPos] = (arr[pointerPos] + 1) > 255 ? 0 : (arr[pointerPos] + 1 );
                break;
            case '<':
                pointerPos = (pointerPos - 1) == -1 ? m - 1 : (pointerPos - 1);
                break;
            case '>':
                pointerPos = (pointerPos + 1) == m ? 0 : (pointerPos + 1);
                break;
            case '[':
                if(arr[pointerPos] == 0 ) {
                    pid = bracket[pid];     // 현재 위치를 닫는 괄호의 위치로 이동함
                }
                break;
            case ']':
                if(arr[pointerPos] != 0) {
                    pid = bracket[pid];     // 현재 위치를 여는 괄호의 위치로 이동함
                }
                break;
            case '.':
                break;
            case ',':
                arr[pointerPos] = (inputPos == i) ? 255 : input.charAt(inputPos++);
        }
        pid++;
    }

}
