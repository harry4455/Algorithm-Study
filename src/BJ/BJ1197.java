/*
    #1197 최소 스패닝 트리

    mst(minimum spanning tree)를 활용하는 문제
    -> spanning tree 중에서 사용된 간선들의 가중치 합이 최소인 트리
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197 {
    static int V,E;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        parent = new int[V+1];

        for(int i=0; i<V+1; i++) {
            parent[i] = i;
        }

        for(int i=0; i<E; i++) {
            stk = new StringTokenizer(br.readLine());
            pq.add(new edge(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        // 시작점과 종료점의 최상위 노드를 찾아서 겹치면 사이클이 생기는 것이기 때문에 continue를 한다.
        // 아닐 경우 union을 통해 연결하여 v를 더해준다.
        for(int i=0; i<E; i++) {
            edge tmp = pq.poll();

            int a = find(tmp.s);
            int b = find(tmp.e);

            if(a==b) continue;
            union(a,b);
            result += tmp.v;
        }

        System.out.println(result);
    }

    // kruskal 알고리즘의 기본 union find!!!
    private static int find(int a) {
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}

// 간선 class
// 우선순위 큐를 사용하기 위해서 Comparable을 통해 정렬 우선순위를 정한다. (V기준)
class edge implements Comparable<edge>{
    int s;
    int e;
    int v;

    public edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(edge o) {
        return o.v>=this.v ? -1 : 1;
    }
}
