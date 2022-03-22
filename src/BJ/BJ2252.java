package BJ;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ2252 {
    static int N,M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N+1];
        indeg = new int[N+1];

        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }

        pro();
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indeg[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
            }
        }

        System.out.println(sb.toString());
    }
}
