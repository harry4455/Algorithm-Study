package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251 {
    /*  시간초과 에러 발생
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int a = w1.length;
        int b = w2.length;

        System.out.println(lcs(w1, w2, a, b));
    }

    private static int lcs(char[] X, char[] Y, int a, int b) {

        if(a == 0 || b == 0)
            return 0;
        if(X[a-1] == Y[b-1])
            return 1 + lcs(X, Y, a-1, b-1);
        else
            return max(lcs(X, Y, a, b-1), lcs(X, Y, a-1, b));
    }

    private static int max(int a, int b) {
        return Math.max(a, b);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] w1 = br.readLine().toCharArray();
        char[] w2 = br.readLine().toCharArray();
        int a = w1.length;
        int b = w2.length;

        // 공집합 표현을 위해 인덱스를 행렬별로 한개씩 추가
        int[][] dp = new int[a+1][b+1];

        // 1부터 시작
        for(int i = 1; i <= a; i++) {
            for(int j=1; j <= b; j++) {
                if(w1[i-1] == w2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}
