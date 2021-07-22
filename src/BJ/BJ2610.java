/**
 * #2610 회의준비
 *
 * 이중배열로 먼저 서로간의 연결 상태를 만들어준 뒤
 * BFS로 연결되어 있는 상태를 확인하여 그룹을 나누어 준다.
 * 이후 플로이드-와샬 알고리즘 수행을 통해 간접연결되어 있는 노드간의 거리를 확인
 * ArrayList로 구분되어 있는 각 그룹내에서 노드마다의 연산 작업을 통해 최댓값이 최소인 노드의 인덱스를 찾아냄
 *
 * 각 그룹마다 위의 알고리즘을 수행한 뒤 찾아낸 인덱스를 하나씩 출력해주면 끝.
 */

package BJ;

import java.io.*;
import java.util.*;

public class BJ2610 {
    static int N;
    static int[][] num;
    static final int INF = 987654321;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        num = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i != j) {
                    num[i][j] = INF;
                }
            }
        }

        // 양방향 인접행렬 구현
        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            num[a][b] = num[b][a] = 1;
        }

        visited = new boolean[N+1];

        ArrayList<Integer> leaderlist = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                leaderlist.add(findLeader(i));
            }
        }

        // 리더의 수와 리더 명단 출력
        StringBuilder sb = new StringBuilder();
        sb.append(leaderlist.size() + "\n");

        Collections.sort(leaderlist);
        for(int leader : leaderlist) {
            sb.append(leader + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findLeader(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;

        ArrayList<Integer> arrList = new ArrayList<>();     // start와 연결된 집합
        arrList.add(start);


        // BFS 알고리즘
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=1; i<=N; i++) {
                if(num[now][i] != INF && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    arrList.add(i);
                }
            }
        }

        // 의사 전달 시간을 기준으로 플로이드 와샬 알고리즘 수행
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(num[i][j] > num[i][k] + num[k][j]) {
                        num[i][j] = num[i][k] + num[k][j];
                    }
                }
            }
        }

        int idx = -1;
        int res = INF;

        for(int i=1; i<=N; i++){
            if(!arrList.contains(i)) {
                continue;
            }

            int total = 0;
            for(int j=1; j<=N; j++) {
                if(!arrList.contains(j)) {
                    continue;
                }

                total = Math.max(total, num[i][j]);
            }

            // 의사 전달 시간의 최댓값이 최소인 인덱스를 찾아야함.
            if(res > total) {
                res = total;
                idx = i;
            }
        }

        return idx;
    }
}
