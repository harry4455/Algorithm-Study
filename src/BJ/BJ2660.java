package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2660 {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while(true) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            if(x == -1 && y == -1) {
                break;
            }

            arr[x][y] = arr[y][x] = 1;  // 친구 관계가 양방향
        }

        // 플로이드 와샬 알고리즘
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int readerScore = INF;

        int[] scoreArr = new int[N+1];      // 친구 점수 목록

        for(int i=1; i<=N; i++) {
            int score = 0;
            for(int j=1; j<=N; j++) {
                if (arr[i][j] != INF) {
                    score = Math.max(score, arr[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder title = new StringBuilder();
        title.append(readerScore + " ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i + " ");
            }
        }

        title.append(readerNum + "\n");

        bw.write(title.toString());
        bw.write(body.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
