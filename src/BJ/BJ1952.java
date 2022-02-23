/*
 * # 달팽이 2
 */

package BJ;

import java.io.*;
import java.util.*;

public class BJ1952 {
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        snail(M,N);
    }

    static void snail(int M, int N) {

        visited = new boolean[M][N];

        int x = 0, y = 0;
        int dir = 1;
        int answer = 0;

        while (!visited[y][x]) {

            visited[y][x] = true;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[ny][nx]) {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
                answer++;
            }

            x += dx[dir];
            y += dy[dir];
        }

        System.out.println(answer-1);
    }
}