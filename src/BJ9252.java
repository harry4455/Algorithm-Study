import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        int[][] dp = new int[word1.length+1][word2.length+1];

        for(int i=1; i <= word1.length; i++) {
            for(int j=1; j <= word2.length; j++) {
                if(word1[i-1] == word2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // 길이 출력
        System.out.println(dp[word1.length][word2.length]);

        int a = word1.length;
        int b = word2.length;

        StringBuffer sbf = new StringBuffer();
        while(!(a == 0 || b == 0)) {
            if(word1[a-1] == word2[b-1]) {
                sbf.append(word1[a-1]);
                a--;
                b--;
            } else if (dp[a][b] == dp[a-1][b]) {
                a--;
            } else if (dp[a][b] == dp[a][b-1]) {
                b--;
            }
        }

        // 문자열 역순으로 출력
        System.out.println(sbf.reverse().toString());

    }
}
