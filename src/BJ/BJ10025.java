package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int min=0, max=0;
        int left, right;
        int sum = 0;
        int sumMax = 0;
        int[] ice = new int[20];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());

            if(i == 0) {
                ice[x] = g;
                min = x;
                max = x;
            } else {
                min = ((min < x) ? min : x);
                max = ((max > x) ? max : x);
                ice[x] = g;
            }


        }

        System.out.println(Arrays.toString(ice));

        for(left = min; left + 2 * K <= max; left++) {
            sum = 0;
            for(int i = 0; i < 2 * K; i++) {
                sum += ice[min + i];
            }
            sumMax = ((sumMax > sum) ? sumMax : sum);
        }

        System.out.println(sumMax);


        /*d[0] = ice[0];

        for(int i=1; i<=1000000; i++) {
            d[i] = d[i-1] + ice[i];
        }

        int ans = 0;

        if(K <= 1000000) {
            for(int i=0; i<=1000000; i++) {
                if(i+K <= 1000000 && Math.abs(i-K) >= 1) {
                    ans = Math.max(ans, d[i+K] - d[i+K-1]);
                }
            }
            System.out.println(ans);
        } else {
            System.out.println(d[1000000]);
        }*/
    }
}
