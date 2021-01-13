package BJ;/*
    #7576 토마토

    bfs 이용해서 풀이 가능
    Queue 활용해서 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7576 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            str = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs(arr, N, M);
    }

    private static void bfs(int[][] arr, int N, int M) {
        Queue<DOT> queue = new LinkedList<DOT>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 익은 토마토가 있는 모든 위치를 큐에 담음
                if(arr[i][j] == 1) {
                    queue.add(new DOT(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            // 다음 턴에 상하좌우 익기에 큐에 담아야댐
            DOT dot = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                // 범위를 벗어날 경우 통과
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                //다음 위치에 토마토가 이미 익었다면 통과
                if(arr[nextX][nextY] != 0) {
                    continue;
                }

                arr[nextX][nextY] = arr[dot.x][dot.y] + 1;
                queue.add(new DOT(nextX, nextY));
            }
        }

        //System.out.println(Arrays.deepToString(arr));

        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max - 1);
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
