/*
 * # BJ21920 서로소 평균
 */
package BJ;

import java.util.*;
import java.io.*;
import java.math.*;

public class BJ21920 {
    public static void main(String[] args) throws IOException {
        long answer = 0;
        long cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        for(int a : arr) {
            int num = gcd(a, X);
            if(num == 1) {
                answer += a;
                cnt++;
            }
        }

        BigDecimal c = new BigDecimal(String.valueOf(answer));
        BigDecimal d = new BigDecimal(String.valueOf(cnt));

        System.out.println(c.divide(d,5));
    }

    static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd (b, a%b);
    }
}