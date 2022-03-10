/**
 * #BJ1015 수열정렬
 *
 * 인덱스 값을 갖고 정렬하여 장난치는 문제
 * 이런 부분이 약하므로 보강하도록 하자
 *
 */

package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1015 {

    static class Elem implements Comparable<Elem>{

        /**
         * idx A 배열의 idx 위치를 기억하는 변수
         * num A[idx]의 원래 값
         */
        public int num, idx;

        @Override
        public int compareTo(Elem o) {
            // TODO
            // 정렬 조건에 맞게 정렬하기
            // 1. num의 비내림차순
            // 2. num이 같으면 idx 오름차순
            return num - o.num;
        }
    }

    static int N;
    static Elem[] B;
    static int[] P;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        B = new Elem[N];
        P = new int[N];

        for(int i=0; i<N; i++) {
            B[i] = new Elem();
            // TODO : Elem의 정의에 맞게 B[i]에 값을 넣어주기
            B[i].num = sc.nextInt();
            B[i].idx = i;
        }

        pro();
    }

    static void pro() {
        // TODO : B 배열 정렬하기
        Arrays.sort(B);

        // TODO : B 배열의 값을 이용해서 P 배열 채우기
        for(int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        // TODO : P 배열 출력하기
        for(int i=0; i<N; i++) {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
}
