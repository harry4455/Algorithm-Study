/*
 kruskal algorithm
 최소의 간선을 선택해나가는 알고리즘

 union-find algorithm
 하나의 cycle이 만들어지지 않도록 Disjoint Set을 표현하는데 활용되는 알고리즘

==========================================================

 List 만들어서 비교
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy05 {

    public static void main(String[] args) {
        int n = 4;  // 섬의 갯수
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] adj = new int[n][n];    // 인접한 섬들 배열 확인하기 [출발지, 도착지]
        for(int i=0; i < costs.length; i++){
            adj[costs[i][0]][costs[i][1]] = adj[costs[i][1]][costs[i][0]] = costs[i][2];    //  연결되어 있는 섬들마다 비용 정해놓기
        }
        boolean[] visit = new boolean[n];
        List<Integer> connect = new ArrayList<>(n+1);
        connect.add(0);
        visit[0] = true;
        while(connect.size() < n) {     // 리스트에 저장된 크기가 총 섬의 크기보다 작을 때
            int min = Integer.MAX_VALUE;
            int minIdx = -1;    // 최소 거리의 도착지 섬 인덱스
            for(int island = 0; island < connect.size(); island++) {
                int i = connect.get(island);    // 섬들 중에 count 해서 지우고 마지막으로 지운 섬
                for(int j = 0; j < n; j++) {
                    // 방문 안했고, i에서 j까지 연결은 되어있고, 그 값이 최소인가
                    if(!visit[j] && adj[i][j] > 0 && adj[i][j] < min) {
                        min = adj[i][j];
                        minIdx = j;
                    }
                }
            }
            visit[minIdx] = true;
            connect.add(minIdx);    // 리스트에 도착지 섬 추가
            answer += min;
        }
        return answer;
    }

    /*  실패한 케이스

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int form, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            System.out.println("차이값");
            System.out.println(this.cost - o.cost);
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
    }*/
}
