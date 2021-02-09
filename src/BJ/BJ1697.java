/*
    #1697 숨바꼭질

    맨 처음에 어떻게 풀어야할지 감도 안옴
    이런 문제에서는 이전에 방문했던 노드나 위치를 기반으로 답을 찾아나가는 것이기 때문에
    bfs를 활용하면 용이하게 풀이가 가능하다.

 */

package BJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {

    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if(N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    private static void bfs(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 1;

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i=0; i<3; i++) {
                int next;

                if(i == 0) {
                    next = temp + 1;
                } else if(i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if(next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if(next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
