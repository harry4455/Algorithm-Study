/**
 * #BJ7795 먹을 것인가 먹힐 것인가
 *
 */
package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ7795 {
    static int T;
    static int N, M, ans;
    static int[] A,B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int i=1; i<=T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            A = new int[N + 1];
            B = new int[M + 1];
            for (int a = 1; a <= N; a++) {
                A[a] = sc.nextInt();
            }
            for (int a = 1; a <= M; a++) {
                B[a] = sc.nextInt();
            }

            pro();
        }
    }

    private static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 L - 1 을 return 한다

        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }
}
