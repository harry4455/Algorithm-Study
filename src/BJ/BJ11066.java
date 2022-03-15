package BJ;

import java.util.*;

public class BJ11066 {
    static int T;
    static int K;
    static int[] num;
    static int[][] sum, Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i=0; i<T; i++) {
            K = sc.nextInt();
            num = new int[K+1];
            sum = new int[K+1][K+1];

            for(int a=1; a<=K; a++) {
                num[a] = sc.nextInt();
            }

            pro();
        }
    }

    private static void pro() {
        preprocess();
        Dy = new int[K+1][K+1];

        for(int len = 2; len <= K; len++) {
            for(int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k+1][j] + sum[i][j]);
                }
            }
        }

        System.out.println(Dy[1][K]);
    }

    private static void preprocess() {
        for(int i=1; i<=K; i++) {
            for(int j=i; j<=K; j++) {
                sum[i][j] = sum[i][j-1] + num[j];
            }
        }
    }
}
