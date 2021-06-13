package BJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16174 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {0,1};
    static int[] dx = {1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        //visited[0][0] = true;
        dfs(new Point(0,0));
        System.out.println("Hing");
    }

    private static void dfs(Point p) {
        int next = arr[p.x][p.y];
        if(next == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int d=0; d<2; d++) {
            int x = p.x + dx[d] * next;
            int y = p.y + dy[d] * next;

            if(x < 0 || y < 0 || x >= N || y >= N) {
                continue;
            }
            if(visited[x][y]){
                continue;
            }

            visited[x][y] = true;
            dfs(new Point(x, y));
        }
    }
}