package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16234 {
    static int[][] arr, check;  // 사람수, 연합국가
    static int N,L,R;
    final static int[] dx = {0,1,0,-1};
    final static int[] dy = {1,0,-1,0};
    static class Info {
        int x,y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int result = 0;

        Info info;
        while(true) {
            int cnt = 0;
            check = new int[N][N];         // 연합국가의 번호를 확인
            int[] tot = new int[2501];      // 해당 국가에 포함된 인구의 합
            int[] number = new int[2501];   // 해당 국가에 속한 칸의 수

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(check[i][j] == 0) {
                        cnt++;
                        check[i][j] = cnt;
                        Queue<Info> queue = new LinkedList<>();
                        queue.offer(new Info(i,j));
                        while(!queue.isEmpty()) {
                            info = queue.poll();
                            int cx = info.x;
                            int cy = info.y;
                            tot[cnt] += arr[cy][cx];
                            number[cnt]++;

                            for(int k=0; k<4; k++) {
                                int nx = cx + dx[k];
                                int ny = cy + dy[k];
                                if(nx>=0  && ny>=0 && nx<N && ny <N && check[ny][nx]==0 && Math.abs(arr[ny][nx]-arr[cy][cx])>=L && Math.abs(arr[ny][nx]-arr[cy][cx])<=R) {
                                    check[ny][nx] = cnt;
                                    queue.offer(new Info(ny,nx));
                                }
                            }
                        }
                    }
                }
            }

            boolean change = false;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int country = check[i][j];
                    int value = tot[country]/number[country];
                    if(arr[i][j] != value) {
                        change = true;
                        arr[i][j] = value;
                    }
                }
            }

            if(!change) break;
            result++;
        }

        System.out.println(result);
    }
}
