/*
    #1913 달팽이

    중심에서 반시계 방향으로 나아가며
    dx,dy 배열로 방향을 정해주며 그려나감, 약간 dfs 때랑 푸는거 비슷
    BJ.Point Class 만들어 주는데 위치 잘못해서 좀 헤맸음
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1913{
    static int N, target;
    static int[][] snail;
    static Point targetPosition;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        snail = new int[N][N];
        makeSnail(snail);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(snail[i][j]);
                if(j != N-1) sb.append(" ");
                if(j == N-1) sb.append("\n");
            }
        }
        sb.append(targetPosition.row+1).append(" ").append(targetPosition.col+1);
        System.out.println(sb.toString());



    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int number = 1;

    private static void makeSnail(int[][] snail) {
        int row = N/2;
        int col = N/2;
        snail[row][col] = 1;
        int length = 1;
        int dirIdx = 0;
        while(true) {
            // 수직 방향
            for(int i=0; i<length; i++) {
                row += dx[dirIdx];
                col += dy[dirIdx];
                snail[row][col] = incNum(row, col);
            }
            dirIdx = (dirIdx+1)%4;

            // 수평 방향
            for(int i=0; i<length; i++) {
                row += dx[dirIdx];
                col += dy[dirIdx];
                snail[row][col] = incNum(row, col);
            }
            dirIdx = (dirIdx+1)%4;
            if(length == N-1) break;
            length++;
        }

        // 마지막 줄 처리
        for(int i=0; i<length; i++) {
            row += dx[0];
            col += dy[0];
            snail[row][col] = incNum(row, col);
        }
    }

    private static int incNum(int row, int col) {
        int nextN = ++number;
        if(nextN == target) targetPosition = new Point(row, col);
        return  nextN;
    }
}

class Point {
    int row;
    int col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}