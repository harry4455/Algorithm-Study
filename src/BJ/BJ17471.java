/*
    #

    1. 2개의 지역구로 나눌 수 있는 부분집합 구하기
    2. 지역구가 정상적을 나누어졌는지 확인하기
    3. 정상일 경우 인구수 차이를 구하여 최솟값 찾기

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17471 {
    static int N, K, MIN, sum, partsum;
    static int[] num;   // 인구수
    static int[][] link;    // 연결된 간선
    static int[] temp;
    static boolean[] check;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        link = new int[N+1][N+1];

        /*for(int i=1; i<N+1; i++) {
            stk = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(stk.nextToken());
        }*/

        System.out.println(Arrays.toString(num));

        /*for(int i=1; i<=N; i++) {
            stk = new StringTokenizer(br.readLine());
            int each = Integer.parseInt(stk.nextToken());
            for(int j=0; j<each; j++) {
                int spot = Integer.parseInt(stk.nextToken());
                link[i][spot] = 1;
            }
        }*/

        MIN = Integer.MAX_VALUE;

        // 부분 집합 만드는 과정
        for(int i=0; i<(N/2)+1; i++) {
            K = i;
            check = new boolean[N+1];
            pick(1,0);
        }

        if(MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }

    }

    private static void pick(int start, int cnt) {
        if(cnt == K) {
             sum = Integer.MAX_VALUE;
             temp = new int[N+1];
             // 부분집합으로 선택되면 1, 아니면 0
             for(int i=1; i<N+1; i++) {
                 if(check[i] == true) {
                     temp[i] = 1;
                 } else {
                     temp[i] = 0;
                 }
             }
             confirm();
             MIN = Math.min(MIN, sum);
             return;
        }
        for(int i=start; i<N+1; i++) {
            check[i] = true;
            pick(i+1, cnt+1);
            check[i] = false;
        }
    }

    private static void confirm() {
        // 모든 지역구가 정상으로 나누어지는지 확인하는 배열
        visited = new boolean[N+1];
        int people1 = 0;
        int people2 = 0;
        for(int i=1; i<=N; i++) {
            // 연결된 곳을 gary method를 통해 재귀로 찾는다.
            if(temp[i] == 1 && !visited[i]) {
                partsum = 0;
                gary(i);
                people1 = partsum;
                break;
            }
        }

        for(int i=1; i<=N; i++) {
            if(temp[i] == 0 && !visited[i]) {
                partsum = 0;
                gary(i);
                people2 = partsum;
                break;
            }
        }

        // 한곳이라도 방문하지 않은 곳이 존재한다면 종료
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                return;
            }
        }

        sum = Math.abs(people1 - people2);
    }

    private static void gary(int x) {
        visited[x] = true;
        partsum += num[x];
        for(int i=1; i<=N; i++) {
            // 방문했는지, 같은 지역구에 속하는지, 연결이 되어 있는지 순서대로 검사
            if(!visited[i] && temp[i] == temp[x] && link[i][x] == 1) {
                gary(i);
            }
        }
    }
}
