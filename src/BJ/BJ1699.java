/*
    #1699 제곱수의 합

    점화식 찾는게 어려움.
 */

package BJ;

import java.util.Scanner;

public class BJ1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];

        dp[1] = 1;
        for(int i=2; i<N+1; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
