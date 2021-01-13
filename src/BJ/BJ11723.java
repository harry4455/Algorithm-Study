package BJ;/*
    비트마스크 활용
 */

import java.io.*;
import java.util.StringTokenizer;

public class BJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int bitset = 0;

        while(N-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String op = stk.nextToken();
            int num;

            // 수행 연산
            // num-1 인 이유는 20이 들어왔을 때, 2^19자리가 20번째 이기 때문. (예시)
            switch (op){
                case "add" :
                    num = Integer.parseInt(stk.nextToken());
                    bitset |= (1 << (num - 1));
                    break;
                case "remove" :
                    num = Integer.parseInt(stk.nextToken());
                    bitset = bitset & ~(1 << (num-1));  // ~ -> NOT, >> -> SHIFT(왼쪽, 오른쪽 자리 변환)
                    break;
                case "check" :
                    num = Integer.parseInt(stk.nextToken());
                    sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(stk.nextToken());
                    bitset ^= (1 << (num-1));   // XOR 연산
                    break;
                case "all" :
                    bitset |= (~0);             // OR 연산
                    break;
                case "empty" :
                    bitset &= 0;                // AND 연산
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
