/*
    #1756 문제집

    위상정렬 알고리즘을 활용하는 문제

    위상정렬이란? https://gmlwjd9405.github.io/2018/08/27/algorithm-topological-sort.html 참고함

    기본적으로 해당 노드나 위치에 진입하는 차수가 0일 경우에 알고리즘이 종료되기 때문에
    차수가 0인 부분을 시작점으로 삼아 다른 노드로 이어나가며 연산하는 방식을 활용함

    또한, queue내에서 작은 번호 순으로 문제를 풀어야 하기 때문에 우선순위 알고리즘을 활용해야 함.
 */

package BJ;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] degree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            degree[y]++;    // 자신을 향하는 화살표의 갯수
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i=1; i<=N; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // degree가 0인 값을 queue에서 뽑는다
            int current = queue.poll();
            System.out.print(current + " ");
            // 뽑힌 곳에서 갈수 있는 곳들을 검색하여 degree를 하나 빼준다
            for(int i=0; i<list[current].size(); i++) {
                int next = list[current].get(i);
                degree[next]--;
                // degree가 0이라면 queue에서 뽑는다
                if(degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
