/**
 * #BJ2470 두 용액
 */
package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2470 {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        solution();
    }

    private static void solution() {
        // TODO Auto-generated method stub

        // A 에 대해 이분 탐색을 할 예정이기에 미리 정렬
        Arrays.sort(arr, 1, N+1);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for(int left = 1; left <= N-1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left] 와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
            int candidate = lower_bound(arr, left + 1, N, -arr[left]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (left < candidate - 1 && Math.abs(arr[left] + arr[candidate - 1]) < bestSum) {
                bestSum = Math.abs(arr[left] + arr[candidate - 1]);
                v1 = arr[left];
                v2 = arr[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (candidate <= N && Math.abs(arr[left] + arr[candidate]) < bestSum) {
                bestSum = Math.abs(arr[left] + arr[candidate]);
                v1 = arr[left];
                v2 = arr[candidate];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    private static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다

        int res = R+1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }
}

