/*
 * # 빛의 경로 사이클
 * 월간 코드 챌린지 시즌3
 *
 * 특별한 알고리즘 보다는 3차원의 배열을 고안해야 했던 문제
 * 2차원 배열에 각 원소마다 4가지 방향에 따른 경우를 추가로 고려해야 했기 때문에, 3차원 배열을 활용함으로써 이를 풀이
 *
 * 각 경우마다 발생하는 경우를 ArrayList에 저장하고, 나중에 int 배열로 치환.
 *
 * 자바 stream 활용하는 부분 특히 잘 확인하고 숙지할 것.
 */

package PG.Level2;

import java.util.ArrayList;

public class lightwayCycle {
    // 아래, 왼, 위, 오른 순서
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int R,C;
    static boolean[][][] visited;

    public static void main(String[] args) {
        String[] grid = {"SL","LR"};
        solution(grid);
    }

    public static int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        R = grid.length;
        C = grid[0].length();

        visited = new boolean[R][C][4];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                for(int d=0; d<4; d++) {
                    if(!visited[i][j][d]) {
                        answer.add(light(grid, i, j, d));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static int light(String[] grid, int r, int c, int d) {
        int cnt = 0;    // 이동거리

        while(true) {
            if(visited[r][c][d]) {
                break;
            }

            cnt++;
            visited[r][c][d] = true;

            if(grid[r].charAt(c) == 'L') {
                d = d == 0 ? 3 : d - 1;
            } else if (grid[r].charAt(c) == 'R') {
                d = d == 3 ? 0 : d + 1;
            }

            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        return cnt;
    }
}
