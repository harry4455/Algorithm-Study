/*
 * # 거리두기 확인하기
 *
 *
 */

package PG.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class keepDistance {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 응시자가 앉아있는 자리를 먼저 찾는다 (P의 위치)
        // 응시자의 위치부터 탐색을 한다.
        // 빈 책상으로만 이동한다. -> 파티션 방향은 이동못하고, 빈 책상으로 이동하면 false라는 결과를 도출하면 되기 때문.

        for(int i=0; i< places.length; i++) {
            answer[i] = isCorrect(places[i]);
        }
        return answer;
    }

    private static int isCorrect(String[] place) {
        for(int i=0; i < place.length; i++) {
            for(int j=0; j < place[i].length(); j++) {
                if(place[i].charAt(j) == 'P') {
                    if(!bfs(place, i, j)) return 0;
                }
            }
        }
        return 1;
    }

    private static boolean bfs(String[] board, int x, int y) {
        Queue<NodeKeepDistance> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board.length];
        queue.offer(new NodeKeepDistance(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            NodeKeepDistance current = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                if(visited[nx][ny] || manhattan > 2) continue;

                visited[nx][ny] = true;
                if(board[nx].charAt(ny) == 'X') continue;
                else if(board[nx].charAt(ny) == 'P') return false;
                else queue.offer(new NodeKeepDistance(nx, ny));
            }
        }
        return true;
    }
}

class NodeKeepDistance {
    int x;
    int y;

    public NodeKeepDistance(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
