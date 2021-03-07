/*
    #1328 고층 빌딩

    동적 프로그래밍 활용해서 풀이

    모든 경우를 연산하고 값을 찾아나가기에는 메모리 과부하가 오기 때문에
    점화식을 구해서 각 단계마다 넘어가는 과정들을 보아야 함.

    2개의 건물이 있는 경우부터 각자 좌, 우 또는 중간에 건물이 새로 추가 되었을 때의 경우의 수를 모두 더해준다.
    이를 점화식으로 나타낸다면

    DP[N][L][R] =  DP[N-1][L-1][R] + DP[N-1][L][R-1] + DP[N-1][R][L]*(N-2)

    으로 표현할 수 있다.

 */

package BJ;

import java.util.Scanner;

public class BJ1328 {
    static final int MOD = 1000000007;
    static long[][][] dp = new long[101][101][101];  // N, L, R 순서
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        long temp;

        dp[1][1][1] = 1;

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=L; j++) {
                for(int k=1; k<=R; k++) {
                    temp = (dp[i - 1][j][k] * (i - 2)) + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1];
                    dp[i][j][k] = temp % 1000000007;
                }
            }
        }
        System.out.println(dp[N][L][R]);
    }
}
