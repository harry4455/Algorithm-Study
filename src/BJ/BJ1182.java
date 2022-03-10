package BJ;/*
    #1182 부분수열의 합
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {
    static int S, N;
    static int cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        set(arr, N, 0, 0);

        if(S == 0){
            cnt--;
        }

        System.out.println(cnt);

        /* 강의 문제 풀이 */
        rec_func(1, 0);
        // cnt가 진 부분집합만 다루는지 확인하기
        if(S == 0) {
            cnt--;
        }
    }

    private static void rec_func(int k, int value) {
        if(k == N+1) {
            // value가 S랑 같은지 확인하기
            if(value == S) cnt++;
        } else {
            //  k 번째 원소를 포함시킬 지 결정하고 재귀호출
            // include
            rec_func(k+1, value + arr[k]);
            // not include
            rec_func(k+1, value);
        }
    }


    private static void set(int[] arr, int N, int idx, int sum) {
        if(idx == N) {
            if(sum == S) {
                cnt++;
            }
            return;
        }

        set(arr, N, idx+1, sum);
        set(arr, N, idx+1, sum+arr[idx]);
    }
}
