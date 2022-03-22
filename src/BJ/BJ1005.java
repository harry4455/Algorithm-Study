package BJ;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1005 {
    static int T,N,K;
    static int[] indeg, T_done, time;
    static ArrayList<Integer>[] adj;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0) {
            N = sc.nextInt();   // 건물의 갯수
            K = sc.nextInt();   // 건물간의 건물순서 규칙
            adj = new ArrayList[N+1];
            indeg = new int[N+1];
            time = new int[N+1];
            T_done = new int[N+1];
            for(int i=1; i<=N; i++) {
                adj[i] = new ArrayList<>();
                time[i] = sc.nextInt();
            }
            for(int i=0; i<K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adj[x].add(y);
                indeg[y]++;
            }
            pro();
        }
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 정렬될 수 있는 정점 찾기
        for(int i=1; i<=N; i++) {
            if(indeg[i] == 0) {
                queue.add(i);
                T_done[i] = time[i];
            }
        }

        // 위상 정렬 순서대로 T_done 계산 함께 해주기
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x] + time[y]);
            }
        }

        int W = sc.nextInt();
        System.out.println(T_done[W]);
    }
}
