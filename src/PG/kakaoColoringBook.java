/*
 * # 카카오 프렌즈 컬러링북
 * 2017 카카오코드 예선
 *
 * bfs로 풀이 가능
 */

package PG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kakaoColoringBook {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int size = 0;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m, n, picture)));
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] > 0 && !visited[i][j]) {
                    size = 1;
                    bfs(picture,i,j,m,n);
                    numberOfArea++;
                    if(maxSizeOfOneArea < size) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private static void bfs(int[][] picture, int x, int y, int m, int n) {
        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(picture[nx][ny] == picture[x][y] && !visited[nx][ny]) {
                        queue.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }
        }
    }


    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
