package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] trees = new int[N+1];
        long max = 0;

        stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            trees[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, trees[i]);
        }

        long start = 0;
        long end = max;

        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for(int tree: trees) {
                if(tree > mid) {
                    sum += tree - mid;
                }
            }

            if(sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
