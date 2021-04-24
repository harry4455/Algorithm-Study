package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1103 {
    static int N,M,sol;
    static boolean lFlag;
    static int[][] map, dp;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        sol = 0;
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String inputSt = br.readLine();
            for(int j=0; j<M; j++) {
                if(inputSt.charAt(j) == 'H') {
                    map[i][j] = 10;
                } else {
                    map[i][j] = inputSt.charAt(j) - 48;
                }
            }
        }

        visit[0][0] = true;
        lFlag = false;
        dfs(0,0,1);

        if(lFlag) bw.write(String.valueOf(-1));
        else bw.write(String.valueOf(sol));

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int y, int x, int cnt) {
        if(cnt > sol) {
            sol = cnt;
        }
        dp[y][x] = cnt;
        for(int i=0; i<4; i++) {
            int num = map[y][x];
            int ny = dy[i] * num + y;
            int nx = dx[i] * num + x;

            if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 10)
                continue;
            if(visit[ny][nx]) {
                lFlag = true;
                return;
            }
            if(dp[ny][nx] > cnt) continue;
            visit[ny][nx] = true;
            dfs(ny, nx, cnt+1);
            visit[ny][nx] = false;
        }
    }
}
