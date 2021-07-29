/**
 * #20166 문자열 지옥에 빠진 호석
 *
 * HashMap 사용
 * 큐에 넣은 문자열이 HashMap에 저장된 값이라면 값을 늘려감
 *
 * 각 지점마다 모든 경우 수를 따져 더해감 -> 같은 지점이어도 다른 방향이라면 다른 경우로 치기 때문
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20166 {
    static int N,M,K;
    static char[][] arr;
    static int[] dr = {-1,1,0,0,-1,-1,1,1};
    static int[] dc = {0,0,-1,1,-1,1,-1,1};
    static HashMap<String, Integer> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new char[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        String[] letter = new String[K];
        hs = new HashMap<>();
        for(int i=0; i<K; i++){
            letter[i] = br.readLine();
            hs.put(letter[i], 0);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bfs(i,j);
            }
        }

        Collection<Integer> values = hs.values();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++) {
            sb.append(hs.get(letter[i])+"\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<Point20166> queue = new LinkedList<>();
        queue.add(new Point20166(r, c, arr[r][c] + ""));
        while(!queue.isEmpty()) {
            Point20166 curr = queue.poll();
            if(hs.get(curr.d) != null) {
                int tmp = hs.get(curr.d);
                hs.put(curr.d, tmp+1);
            }
            if(curr.d.length() == 5) {
                continue;
            }
            for(int i=0; i<8; i++) {
                int nr = curr.R + dr[i];
                int nc = curr.C + dc[i];

                if(nc < 0 && ( nr >= 0 && nr < N)) {    // left
                    nc = M - 1;
                } else if(nc >= M && (nr >= 0 && nr < N)) {   // right
                    nc = 0;
                } else if(nr >= N && (nc >= 0 && nc < M)) {   // down
                    nr = 0;
                } else if(nr < 0 && (nc >= 0 && nc < M)) {    // up
                    nr = N - 1;
                } else if (nr < 0 && nc < 0){   // left-up
                    nr = N - 1;
                    nc = M - 1;
                } else if (nr >= N && nc >= M) {  // right-down
                    nr = 0;
                    nc = 0;
                } else if (nr >= N && nc < 0) {  // left-down
                    nr = 0;
                    nc = M-1;
                } else if (nr < 0 && nc >= M) {  // right-up
                    nr = N - 1;
                    nc = 0;
                }

                queue.add(new Point20166(nr, nc, curr.d + arr[nr][nc]));
            }
        }
    }
}

class Point20166 {
    int R;
    int C;
    String d;

    public Point20166(int R, int C, String d) {
        this.R = R;
        this.C = C;
        this.d = d;
    }
}
