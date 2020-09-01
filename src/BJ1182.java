/*
    #1182 부분수열의 합
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {
    static int S;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];
        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        set(arr, N, 0, 0);

        if(S == 0){
            cnt--;
        }

        System.out.println(cnt);
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
