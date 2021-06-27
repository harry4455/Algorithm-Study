package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1058 {
    static int N, MAX_VALUE = 987564321;
    static int[][] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new int[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                if(str.charAt(j)=='N') friends[i][j] = MAX_VALUE;
                else friends[i][j] = 1;
                if(i==j) friends[i][j] = 0;
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(friends[i][j] > friends[i][k] + friends[k][j]){
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            int cnt = 0;
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                if(friends[i][j] <= 2) cnt++;
            }
            if(max < cnt) max = cnt;
        }
        System.out.println(max);
    }
}
