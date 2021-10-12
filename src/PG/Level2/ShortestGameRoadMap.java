/*
 * # 게임 맵 최단거리
 *
 * bfs를 활용하여 풀이 가능.
 */

package PG.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestGameRoadMap {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        answer = bfs(0,0,maps);

        return answer;
    }

    private static int bfs(int row, int col, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col, 1));
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.row == n-1 && node.col == m-1) return node.cost;

            for(int i=0; i<4; i++) {
                int nx = node.row + dx[i];
                int ny = node.col + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int row;
        int col;
        int cost;

        public Node (int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}
