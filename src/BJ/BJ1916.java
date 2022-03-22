package BJ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1916 {

    static int N,M,start,end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N+1];
        edges = new ArrayList[N+1];

        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = sc.nextInt();
        end = sc.nextInt();

        pro();
    }

    private static void pro() {
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        // 모든 정점까지의 거리를 무한대로 초기화하기
        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임이 보장되어야 함.
        for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        // 다른 방법) PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);


        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복
        while(!pq.isEmpty()) {
            Info info = pq.poll();

            if(dist[info.idx] < info.dist) continue;
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    private static class Edge {
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Info {
        public int idx, dist;

        public Info() {

        }

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
