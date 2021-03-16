/*
    #2169 로봇 조종하기

    주어진 맵 크기에서 좌측상단부터 우측하단까지 동,서,남 방향으로만 나아가며 합계가 최대가 되는 경우를 찾는다.

    세 방향에 대한 dp 배열을 놓고 최대값을 찾으며 반복문 내에서 더해나가면 된다고 생각했으나
    서쪽 이동의 경우에서 문제가 발생함

    따라서 temp라는 배열을 두어 좌우, 우좌 이동에 대한 경우를 모두 구하고 최댓값을 찾는 방식으로 진행

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2169 {
    static int N,M;
    static int[][] map;
    static int[][] dp;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        temp = new int[2][M+2];

        // map 입력
        for(int i=1; i<=N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 맨위 왼쪽부터 시작
        dp[1][1] = map[1][1];

        // 첫 번째 줄 dp 입력 (왼쪽에서 오른쪽으로 가는 방향 밖에 없음)
        for(int j=2; j<=M; j++) {
            dp[1][j] = map[1][j] + dp[1][j-1];
        }

        // 두 번째 줄부터 입력
        for(int i=2; i<=N; i++) {
            // 초기화
            temp[0][0] = dp[i-1][1];

            // 왼쪽에서 오른쪽
            for(int j = 1; j <= M; j++) {
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j])+ map[i][j];
            }

            // 오른쪽에서 왼쪽으로
            temp[1][M+1] = dp[i-1][M];
            for(int j = M; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
