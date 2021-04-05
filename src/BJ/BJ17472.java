/*
    #17472 다리 만들기 2

    처음에 감도 안와서 블로그 참고함
    mst (minimum spanning tree)를 활용하는 문제라고 해서 백준 1197 문제를 먼저 풀고 해당 문제 풀이 진행

    1. 각 섬에 번호를 붙여줌 (섬을 구분하기 위함) - bfs 활용
    2. 각 좌표에서 최대로 만들 수 있는 다리를 모두 만들어 우선순위 큐에 넣어준다.
    (kruskal을 사용하기 위해 edge 클래스를 만들어 Comparable를 implement 해준다.)
    3. kruskal 알고리즘을 이용해 최소 간선의 합을 구해준다.

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17472 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N,M;
    static int island = 0;
    static int result = 0;
    static int bridge_count = 0;
    static int[] parents;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // bfs를 통해 섬에 번호를 부여한다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    island++;
                    bfs(new dot(i,j));
                }
            }
        }

        /* 각 좌표에서 만들 수 잇는 최대의 다리를 만든다
        다리의 길이는 2이상이어야 하므로, 2이상이면 pq에 넣는다.*/
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    makeBridge(new dot(i,j), map[i][j]);
                }
            }
        }

        /* 다리를 다 만들었으면 크루스칼 알고리즘을 실행
        pq의 간선만큼 반복하면서 사이클을 확인하면서 최소 간선의 합을 구한다*/
        parents = new int[island+1];
        
        for(int i=0; i<parents.length; i++) {
            parents[i] = i;
        }

        int size = pq.size();
        for(int i=0; i<size; i++) {
            edge tmp = pq.poll();

            int a = find(tmp.s);
            int b = find(tmp.e);

            if(a==b) continue;

            union(tmp.s, tmp.e);
            result += tmp.v;
            bridge_count++;
        }

        // result가 0이거나 다리의 갯수가 (섬의갯수 - 1) 이 아니면 -1을 출력한다.
        if(result == 0 || bridge_count != island - 1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }

    // kruskal 알고리즘을 위한 find, union 함수
    private static int find(int a) {
        if(a == parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }

    private static void union(int s, int e) {
        int aRoot = find(s);
        int bRoot = find(e);

        if(aRoot!=bRoot) {
            parents[aRoot] = e;
        } else {
            return;
        }
    }

    /* 상하좌우 중 한 방향을 계속 이동하면서 다른 섬이 나올 때 까지 반복한다.
    중간에 좌표를 넘어가거나, 자신과 같은 번호가 나오면 좌표와 length를 초기화 한 뒤에 넘어간다.*/
    private static void makeBridge(dot d, int num) {
        int x2 = d.x;
        int y2 = d.y;
        int length = 0;

        for(int i=0; i<4; i++){
            while(true) {
                x2 += dx[i];
                y2 += dy[i];

                if(x2>=0 && x2<N && y2>=0 && y2<M) {
                    if(map[x2][y2] == num) {
                        length = 0;
                        x2 = d.x;
                        y2 = d.y;
                        break;
                    } else if(map[x2][y2] == 0) {
                        length++;
                    } else {
                        // 길이가 1보다 크면 pq에 추가
                        if(length > 1) {
                            pq.add(new edge(num, map[x2][y2], length));
                        }
                        length = 0;
                        x2 = d.x;
                        y2 = d.y;
                        break;
                    }
                } else {
                    length = 0;
                    x2 = d.x;
                    y2 = d.y;
                    break;
                }
            }
        }
    }

    static void bfs(dot d) {
        Queue<dot> q = new LinkedList<dot>();
        visited[d.x][d.y] = true;
        map[d.x][d.y] = island;
        q.add(d);

        while(!q.isEmpty()) {
            dot t = q.poll();
            int x = t.x;
            int y = t.y;

            for(int i=0; i<4; i++) {
                int x2 = x + dx[i];
                int y2 = y + dy[i];

                if(x2>=0 && x2<N && y2>=0 && y2<M && map[x2][y2] == 1 && !visited[x2][y2]) {
                    q.add(new dot(x2, y2));
                    map[x2][y2] = island;
                    visited[x2][y2] = true;
                }
            }
        }
    }
}

class dot {
    int x;
    int y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 간산 class: value를 기준으로 compareTo를 overriding
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
        return o.v>=this.v? -1:1;
    }
}
