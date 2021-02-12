/*
    #10971 외판원 순회2

    dfs로 완전하게 순회하며 min값을 갱신해나간다.
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static long min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                W[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }

    private static void dfs(int start, int i, int cnt, int sum) {
        if(cnt == N && start == i){
            min = Math.min(min, sum);
            return;
        }

        for(int j=0; j<N; j++) {
            if(W[i][j] == 0){
                continue;
            }

            if(!visited[i] && W[i][j] > 0 ){
                visited[i] = true;
                sum += W[i][j];
                dfs(start, j, cnt+1, sum);
                visited[i] = false;
                sum -= W[i][j];
            }
        }

    }
}
