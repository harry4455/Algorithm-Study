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

import java.io.*;

public class BJ1913 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        solve(n, t);
    }

    public static void solve(int n, int t){
        int[][] map = new int[n][n];
        int value = 1;

        int x = n/2, y = n/2;

        int limit = 1;

        while(true) {
            // 상우하좌 순서

            for(int i=0; i<limit; i++) {
                map[y--][x] = value++;
            }

            if(value-1 == n*n) break;

            for(int i=0; i<limit; i++) {
                map[y][x++] = value++;
            }

            limit++;

            for(int i=0; i<limit; i++) {
                map[y++][x] = value++;
            }

            for(int i=0; i<limit; i++) {
                map[y][x--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();

        int tx = 0, ty = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(t == map[i][j]) {
                    tx = j+1;
                    ty = i+1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);

        System.out.println(sb.toString());
    }
}