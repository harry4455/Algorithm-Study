/*
    처음에 문제 뜻이 이해가 잘 안갔음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(solve(n));
    }

    private static int solve(long n) {
        long sum = 0;
        int addNum = 1;
        while(n >= sum) {
            sum += addNum++;
        }

        return sum == n ? addNum - 1 : addNum - 2;

    }
}
