/*
    #16234 인구 이동

    dfs로 방문하지 않은 곳을 시작으로 하여 조건안에 맞는 영역을 list에 담음
    탐색 후 변동이 있는 경우, 데이터 평균값을 구해서 수정

    이후 다시 초기화 한 뒤, 인구이동이 필요한지 확인하고 sec를 늘려가며 지속적으로 진행
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16234 {
    static int[][] arr;
    static boolean[][] visited;
    static int N,L,R;
    final static int[] dx = {1,-1,0,0};
    final static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        int sec = 0;
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(true) {
            visited = new boolean[N][N];    // 방문 초기화
            if(!check()) {
                sec++;
            } else {
                break;
            }
        }
        System.out.println(sec);
    }

    private static boolean check() {
        List<Node16234> nList;
        boolean isDone = true;  // 이동이 더 이상 필요없을 경우 true
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 방문하지 않은 경우
                if(!visited[i][j]) {
                    nList = new LinkedList<>();
                    nList.add(new Node16234(i,j));
                    int sum = dfs(i,j,nList,0); // 리스트에 저장된 값의 합
                    if(nList.size() > 1) {  // 리스트 크기가 1 이상인 경우 (인구이동이 필요한 데이터가 있는 경우
                        change(sum, nList); // 평균값 계산해서 rodtls
                        isDone = false;
                    }
                }
            }
        }
        return isDone;
    }

    private static void change(int sum, List<Node16234> nList) {
        int avg = sum / nList.size();
        for(Node16234 node : nList) {
            arr[node.x][node.y] = avg;
        }
    }

    private static int dfs(int x, int y, List<Node16234> nList, int sum) {
        visited[x][y] = true;
        sum = arr[x][y];

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) {
                continue;
            }

            if(!visited[nextX][nextY]) {
                int d = Math.abs(arr[x][y] - arr[nextX][nextY]);
                if(d >= L && d <= R) {
                    nList.add(new Node16234(nextX, nextY));
                    sum += dfs(nextX, nextY, nList, sum);
                }
            }
        }
        return sum;
    }
}

class Node16234{
    int x;
    int y;
    public Node16234(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
