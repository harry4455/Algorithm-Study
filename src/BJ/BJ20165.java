/**
 * #20165 인내의 도미노 장인 호석
 *
 * 시뮬레이션.... 문제 이해하는데 좀 시간이 걸림
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20165 {
    static int N, M, R;
    static int[][] map, tmp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = { 0, 1, 0, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        while(R-- > 0) {
            // 공격
            stk = new StringTokenizer(br.readLine());
            int AttR = Integer.parseInt(stk.nextToken())-1;
            int AttC = Integer.parseInt(stk.nextToken())-1;
            char dir = stk.nextToken().charAt(0);

            Attack(AttR, AttC, dir);

            // 수비
            stk = new StringTokenizer(br.readLine(), " ");
            int DefR = Integer.parseInt(stk.nextToken()) - 1;
            int DefC = Integer.parseInt(stk.nextToken()) - 1;
            int t = tmp[DefR][DefC];
            map[DefR][DefC] = t;
        }

        System.out.println(answer);
        for(int[] output : map) {
            for(int out: output) {
                System.out.print(out>=1 ? "S " : "F ");
            }
            System.out.println();
        }
    }

    private static void Attack(int r, int c, char dir) {
        int direction = 0;
        switch(dir) {
            case 'E' :
                direction = 1;
                break;
            case 'W' :
                direction = 3;
                break;
            case 'S' :
                direction = 2;
                break;
            case 'N' :
                direction = 0;
                break;
            default:
                break;
        }

        int height = map[r][c];
        int nr = r;
        int nc = c;
        while(height > 0) {
            if(map[nr][nc] > 0) {
                height = Math.max(height, map[nr][nc]);
                height--;
                map[nr][nc] = 0;
                answer++;
            } else {
                height--;
            }

            nr += dr[direction];
            nc += dc[direction];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
        }
    }

}
