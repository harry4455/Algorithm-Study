/**
 * #2617 구슬 찾기
 *
 * 플로이드 와샬 알고리즘 활용
 * 이를 통해 내 앞과 뒤에 위치해야하는 구슬의 수를 알 수 있음
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[N+1][N+1];

        int half = (N/2) + 1;

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            // 크기 a > b
            arr[a][b] = 1;
            arr[b][a] = -1;
        }

        for(int j=1; j<=N; j++) {
            for(int k=1; k<=N; k++) {
                for(int l=1; l<=N; l++) {
                    if(arr[l][j] != 0 && arr[k][j] == arr[j][l]) {
                        arr[k][l] = arr[k][j];
                    }
                }
            }
        }


        int[] big = new int[N+1];
        int[] small = new int[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) {
                if(arr[i][j] == 1) {
                    big[i]++;
                }

                if(arr[j][i] == 1) {
                    small[i]++;
                }
            }
        }

        int ans = 0;

        for(int i=1; i<=N; i++) {
            if(big[i] >= half) ans++;
            if(small[i] >= half) ans++;
        }
        System.out.println(ans);
    }
}
