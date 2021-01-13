package BJ;

import java.io.*;
import java.util.*;

public class BJ2748 {
    static long[] dp;
    public static void main(String []args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1];

        for(int i=0; i< N+1; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibonacci(N));
    }

    public static long fibonacci(int N) {
        if(dp[N] == -1) {
            dp[N] = fibonacci(N-1) + fibonacci(N-2);
        }
        return dp[N];
    }
}
