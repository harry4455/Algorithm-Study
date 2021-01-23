/*
    #2217 로프

    제일 짧은 길이의 로프 이상을 매달면 끊어짐.
    따라서 가장 짧은 길이의 로프를 기준으로함.
    거기에 로프 수 만큼 곱해주면 최대 매달 수 있는 중량 완성.

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        long max = 0;
        for(int i=N-1; i>=0; i--) {
            arr[i] = arr[i] * (N-i);
            if(max < arr[i]) max = arr[i];
        }

        System.out.println(max);



    }
}
