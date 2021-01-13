package BJ;/*
    #5582 공통 부분 문자열

    LCS(Longest Common Subsequence)
    전형적인 DP 문제 중 하나

    str1 = ABRACADABRA
    str2 = ECADADABRBCRDARA

 */

import java.util.Scanner;

public class BJ5582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] ch1 = sc.next().toCharArray();
        char[] ch2 = sc.next().toCharArray();
        int[][] LCS = new int[ch1.length+1][ch2.length+1];

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= ch1.length; i++) {
            for(int j=1; j <= ch2.length; j++) {
                if(ch1[i-1] == ch2[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }
                ans = Math.max(ans, LCS[i][j]);
            }
        }
        System.out.println(ans);
    }
}
