/*
    #1806 부분합

    투 포인터를 활용한 문제 풀이

    처음에 어떻게 풀어야 하나 고민했는데, 문제를 제대로 안 읽었다.
    연속된 숫자에서만 부분합을 찾으면 되는 것이었기에 포인터 2개로 잡아서 연속하며 진행하는 풀이로 작성
 */
package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int ans = 100001, sum = 0;
        int firstPointer = 0, secondPointer = 0;
        while(true) {
            if(sum >= S) {
                sum -= arr[firstPointer++];
                ans = Math.min(ans, (secondPointer - firstPointer) + 1);
            } else if(secondPointer == N) break;
            else sum += arr[secondPointer++];
        }
        if(ans == 100001) {
            bw.write(0 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
