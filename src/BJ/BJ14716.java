package BJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14716 {
    static int N,M,ans;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<Point>();

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    queue.add(new Point(i,j));
                    bfs();
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if(!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        ans++;
    }
}