package BJ;/*
    #2447 별 찍기 - 10
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ2447 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new char[N][N];

        star(0, 0, N, false);

        for(int i=0; i<N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void star(int x, int y, int N, boolean blank) {
        // 공백칸일 경우
        if(blank) {
            for(int i=x; i<x+N; i++) {
                for(int j=y; j<y+N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 단위일 경우
        if(N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int cnt = 0;    // 별 출력 누적
        for(int i=x; i<x+N; i += size) {
            for(int j=y; j<y+N; j += size) {
                cnt++;
                if(cnt == 5) {  // 공백 칸일 경우 (9개 순차로 돌때 가운데가 5번째)
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }

            }
        }
    }
}
