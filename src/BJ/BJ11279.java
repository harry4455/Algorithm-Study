/*
    #11279 최대 힙

    우선순위 큐 활용해서 푸는 간단한 문제
 */

package BJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0; i<x; i++) {
            int n = sc.nextInt();
            if(n == 0 ) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(n);
            }
        }
    }
}
