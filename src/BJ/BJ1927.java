/*
    #1927 최소 힙

    우선 순위 큐 활용해서 푸는 간단한 문제
 */

package BJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for(int i=0; i<N; i++) {
            int num = sc.nextInt();

            if(num == 0 ) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(num);
            }
        }
    }
}
