/*
    #10942 팰린드롬?

    동적프로그래밍을 이용한 풀이법
    2차원의 dp 배열에 먼저 주어진 숫자에 대한 Palindrome 조건 여부를 확인하여 값을 채운다. (만족하면 1, 아닐시 0)
    조건 확인 여부는 생각보다 어렵지 않음.
    start, end 기준으로 배열 값을 채울 때, 먼저 1자리 숫자는 당연하게도 만족함
    그 이후 2자리나 3자리로 Palindrome 확인이 필요한 경우에는 조건식에 맞추어 비교하면 된다.

    이후 입력하는 start, end를 dp에 대입해 결과를 확인하고 출력하면 된다.

    대부분의 Palindrome 문제는 기본적으로 비슷하게 풀이하면 될듯

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        dp = new boolean[N+1][N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        solve(arr, N);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            if(dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }

    private static void solve(int[] arr, int n) {
        for(int i=1; i<=n; i++) {
            dp[i][i] = true;
        }

        for(int i=1; i<=n-1; i++) {
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for(int i=2; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                }
            }
        }
    }
}
