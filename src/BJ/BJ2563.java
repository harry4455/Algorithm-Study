package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        int cnt = 0;

        while(N-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            for(int i=x-1; i<x+9; i++) {
                for(int j=y-1; j<y+9; j++) {
                    if(!arr[i][j]) {
                        arr[i][j] = true;
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}
