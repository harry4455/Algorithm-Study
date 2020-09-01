/*
    #2583 영역 구하기
*/

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2583 {

    // string to num 변환
    static int toNum(String s) {
        return Integer.parseInt(s);
    }

    static String[] str;
    static int[][] arr; // 전체 map 배열
    static int M,N,K;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int area;    // 영역 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<K; i++) {
            stk = new StringTokenizer(br.readLine());
            setSquare(toNum(stk.nextToken()), toNum(stk.nextToken()), toNum(stk.nextToken()), toNum(stk.nextToken()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int cnt = 0;

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                area = 0;
                if(arr[i][j] == 0) {
                    cnt++;
                    dfs(i,j);
                    pq.offer(area);
                }
            }
        }

        bw.write(cnt + "\n");
        while(!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }
        bw.flush();
        bw.close();
    }

    private static void setSquare(int x1, int y1, int x2, int y2) {
        for(int i=y1; i<y2; i++) {
            for(int j=x1; j<x2; j++) {
                arr[i][j] = 1;
            }
        }
    }

    private static void dfs(int x, int y) {
        arr[x][y] = 1;
        area++;

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if(arr[nextX][nextY] == 0) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
