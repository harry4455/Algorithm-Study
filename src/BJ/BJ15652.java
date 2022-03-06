/**
 * # BJ15652 N과 M(4)
 */

package BJ;

import java.util.Scanner;

public class BJ15652 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];

        solution(1);

        System.out.println(sb.toString());
    }

    /**
     * 재귀함수
     * M개를 전부 고르면 -> 조건에 맞는 탐색을 한 가지 성공한 것
     * M개를 고르지 않으면 -> k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다
     * @param k
     */
    private static void solution(int k) {
        if(k == M+1) {
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            int start = selected[k-1];
            if(start == 0) start = 1;
            for(int cand = start; cand <= N; cand++) {
                selected[k] = cand;
                //k+1 번 ~ N 번을 탐색하는 일이 남음
                solution(k+1);
                selected[k] = 0;
            }
        }
    }
}
