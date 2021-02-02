/*
    #2606 바이러스

 */

package BJ;

import java.util.Scanner;

public class BJ2606 {
    static int[][] map;
    static boolean[] visit;
    static int n,m,v;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 컴퓨터 갯수
        m = sc.nextInt();   // 연결된 컴퓨터 쌍의 수
        v = 1;              // 탐색을 시작할 정점의 번호
        map = new int[n+1][n+1];    // 정점간 탐색 경롤르 저장할 배열
        visit = new boolean[n+1];   // 정점의 탐색 여부 체크

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));
        sc.close();


    }

    private static int dfs(int i) {

        visit[i] = true;

        for(int j=1; j<=n; j++) {
            if(map[i][j] == 1 && visit[j] == false) {
                count++;
                dfs(j);
            }
        }

        return count;
    }
}
