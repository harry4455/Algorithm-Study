/*
 kruskal algorithm
 최소의 간선을 선택해나가는 알고리즘

 union-find algorithm
 하나의 cycle이 만들어지지 않도록 Disjoint Set을 표현하는데 활용되는 알고리즘

 */

import java.util.PriorityQueue;

public class Greedy05 {

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int form, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> adj;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();

        for(int i=0; i < costs.length; ++i){
            Edge edge = new Edge(costs[i][0], costs[i][1], costs[i][2]);
            adj.offer(edge);
        }

        for(int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        while(!adj.isEmpty()) {
            Edge edge = adj.poll();

            if(find(edge.from) == find(edge.to)) continue;
            else {
                union(edge.from, edge.to);
                answer += edge.cost;
            }
        }

        


        return answer;
    }

    private static void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if(rootA != rootB) parent[rootB] = rootA;
    }

    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}
