/*
    #2098 외판원 순회

    거의 인터넷 해설 보면서 풀이함
    외판원 문제는 항상 헷갈림

    dp배열로 메모이제이션에 필요한 크기의 배열을 선언해서 무한대로 값을 채움

 */

package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2098 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int INF = 16 * 1_000_000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][(1 << N) - 1];

        //System.out.println(Arrays.deepToString(dp));

        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], INF);
        }

        //System.out.println(Arrays.deepToString(dp));

        for(int i=0; i<N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        //System.out.println(Arrays.deepToString(arr));

        bw.write(tsp(0,1) + "\n");
        //System.out.println(Arrays.deepToString(dp));
        
        br.close();
        bw.close();
    }

    private static int tsp(int node, int visit) {

        // 모든 지점을 방문한 경우
        if(visit == (1 << N) -1 ) {
            if(arr[node][0] == 0) return INF;
            return arr[node][0];
        }

        // 이미 계산을 한 경우
        if(dp[node][visit] != INF) {
            return dp[node][visit];
        }

        for(int i=0; i < N; i++) {
            int next = visit | (1 << i);
            // i번 노드에 대해서 길이 없거나 이미 방문한 경우
            if(arr[node][i] == 0 || (visit & (1 << i)) != 0) continue;

            dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + arr[node][i]);
        }

        return dp[node][visit];
    }
}
