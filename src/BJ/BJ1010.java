package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            int[][] dp = new int[N+1][M+1];

            for(int n=2; n<=N; n++) {
                dp[n][1] = 0;
            }

            for(int m=1; m<=M; m++) {
                dp[1][m] = m;
            }

            // dp[n][m] = dp[n-1][m-1] + dp[n][m-1]

            for(int x = 2; x<=N; x++){
                for(int y=1; y<=M; y++) {
                    dp[x][y] = dp[x][y-1] + dp[x-1][y-1];
                }
            }

            sb.append(dp[N][M]).append('\n');
        }

        System.out.println(sb);
    }
}
