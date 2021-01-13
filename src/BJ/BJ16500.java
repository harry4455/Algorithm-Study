package BJ;/*
    #16500 문자열 판별

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ16500 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[100];
        int[] dp = new int[101];

        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        dp[words.length] = 1;

        for(int pos = word.length() - 1; pos >= 0; pos--) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                //System.out.println(word.charAt(pos));
                //System.out.println(words[j].charAt(0));
                if ((word.charAt(pos) == words[j].charAt(0)) && (dp[pos + words[j].length()] == 1)) {
                    dp[pos] = 1;
                    break;
                } else {
                    dp[pos] = 0;
                }
            }
        }

        System.out.println(dp[0]);

    }
}
