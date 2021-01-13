package BJ;/*
    #11403 경로찾기
    참고: https://hees-dev.tistory.com/21, https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11403 {
    static int[][] arr;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int tmp;

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1) {
                    queue.add(j);
                }
            }
            while(!queue.isEmpty()) {
                tmp = queue.poll();
                BFS(i, tmp);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }

    private static void BFS(int i, int tmp) {   // i 행 검사, temp는 큐에서 나온 열
        arr[i][tmp] = 1;    // 행렬순, 우선 여긴 i에서 j로 연결됨
        for(int j=0; j<arr[0].length; j++) {    // 행에서 열마다 검사
            if(arr[tmp][j] == 1 && arr[i][j] != 1) {    // 무한루프 방지 조건 추가
                queue.add(j);
            }
        }
    }
}
