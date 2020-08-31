/*
  #2178 미로탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2178 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);   // 행 갯수
        M = Integer.parseInt(str[1]);   // 열 갯수

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            str = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<DOT> queue = new LinkedList<DOT>();
        queue.add(new DOT(x,y));

        while(!queue.isEmpty()) {
            DOT d = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if(visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new DOT(nextX, nextY));
                map[nextX][nextY] = map[d.x][d.y] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }


    private static class DOT {
        int x;
        int y;

        DOT(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
