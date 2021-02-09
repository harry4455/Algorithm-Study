/*

    #1753 최단경로

    다익스트라 알고리즘을 활용해서 풀이
    노드 클래스를 활용하여 값 오름차순 정렬
    여기에 우선순위 큐까지 활용

 */

package BJ;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class BJ1753 {
    private static final int INF = 100_000_000;
    static int V,E,K;
    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist, INF);

        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
        }

        // list에 그래프 정보를 초기화
        for(int i=0; i<E; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            // start에서 end로 가는 가중치
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();

        // 다익스트라 알고리즘
        dijkstra(K);

        // 출력
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb.toString());

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Node node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
