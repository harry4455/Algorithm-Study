package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    static int N, M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        trees = new int[N+1];
        long max = 0;

        stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            trees[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, trees[i]);
        }

        pro();

        /*long start = 0;
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
        System.out.println(end);*/
    }

    private static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!

        while (L <= R) {
            int mid = (int) ((L + R) / 2);
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (trees[i] > H) {
                sum += trees[i] - H;
            }
        }
        return sum >= M;
    }
}
