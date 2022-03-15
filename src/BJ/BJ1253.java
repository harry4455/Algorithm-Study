package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1253 {
    static int N;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        pro();
    }

    private static void pro() {
        Arrays.sort(arr, 1, N+1);

        for(int i=1; i<=N; i++) {
            if(good(i)) ans++;
        }

        System.out.println(ans);
    }

    private static boolean good(int target_idx) {
        int L = 1, R = N;
        int target = arr[target_idx];

        while (L < R) {
            // target_idx 숫자가 합 연산에 포함되면 안되므로 L,R이 target_idx에 도달하면 바로 넘겨준다
            if(L == target_idx) L++;
            else if (R == target_idx) R--;
            else {
                if(arr[L] + arr[R] > target) R--;
                else if (arr[L] + arr[R] == target) return true;
                else L++;
            }
        }
        return false;
    }
}
