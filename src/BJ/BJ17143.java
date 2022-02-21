/*
 * # BJ17143 낚시왕
 *
 * 여러 값을 갖고 연산햐야 할 때는 "클래스 구조체"를 활용하자
 * 배열에 구조체별로 값들을 관리함.
 *
 * ++ 방향 바꾸는 것을 고려해서 [상하좌우] 보다는 [상좌하우] 이런식으로 시계방향 or 반시계방향으로 index 잡는 것이 좋음
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17143 {

    public static int R,C,M;
    public static Shark[][] map;
    // 상좌하우 (0,1,2,3)
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(stk.nextToken()); // 행의 수
        C = Integer.parseInt(stk.nextToken()); // 열의 수
        M = Integer.parseInt(stk.nextToken()); // 상어의 수

        map = new Shark[R][C];

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(stk.nextToken()); // 행
            int c = Integer.parseInt(stk.nextToken()); // 열
            int s = Integer.parseInt(stk.nextToken()); // 속력
            int d = Integer.parseInt(stk.nextToken()); // 이동방향 (상,하,우,좌)
            int z = Integer.parseInt(stk.nextToken()); // 크기

            // 상좌하우
            if(d == 1) d = 0;
            else if(d == 4) d = 1;

            map[r-1][c-1] = new Shark(r-1, c-1, s, d, z);  // 맵에 상어 저장할
        }

        for(int col = 0; col < C; col++) {
            // 1. 낚시왕 이동
            for(int row = 0; row < R; row++) {
                // 2. 가장 가까운 상어 크기를 정답에 더해줌
                if(map[row][col] != null) {
                    answer += map[row][col].z;
                    map[row][col] = null;  // map에서 상어 제거
                    break;
                }
            }

            // 3.상어 이동
            Queue<Shark> queue = new LinkedList<>();
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] != null) {
                        queue.add(new Shark(i,j,map[i][j].s, map[i][j].d, map[i][j].z));
                    }
                }
            }

            map = new Shark[R][C];

            //상어 한마리씩 꺼내서 이동
            while(!queue.isEmpty()) {
                Shark sm = queue.poll();

                // 속력만큼 상어 이동
                int speed = sm.s;
                // 시간 초과로 최소한의 이동을 위해 나머지 연산
                if(sm.d == 0 || sm.d == 2) { // 상하
                    speed %= (R-1) * 2;
                } else if(sm.d == 1 || sm.d == 3) { // 좌우
                    speed %= (C-1) * 2;
                }

                for(int s=0; s<speed; s++) {
                    // 현재 r,c에 방향에 맞게 한칸씩 추가하며 위치 이동
                    int newR = sm.r + dx[sm.d];
                    int newC = sm.c + dy[sm.d];

                    // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
                    if(newR < 0 || newR >= R || newC < 0 || newC >= C) {
                        sm.r -= dx[sm.d];
                        sm.c -= dy[sm.d];
                        sm.d = (sm.d + 2) % 4;  // 방향 반대로
                        continue;
                    }

                    sm.r = newR;
                    sm.c = newC;
                }

                // 4. 새로운 위치가 빈 공간인지 이미 상어가 있는지 확인하기
                if(map[sm.r][sm.c] != null) {
                    if(map[sm.r][sm.c].z < sm.z) {
                        map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z); // 현재 상어 넣어줌
                    }
                }else {
                    map[sm.r][sm.c] = new Shark(sm.r, sm.c, sm.s, sm.d, sm.z);
                }
            }
        }

        System.out.println(answer);

    }
}

// 상어 정보를 저장할 클래스
class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;

    Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}
