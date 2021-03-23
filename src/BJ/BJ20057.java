/*
    #20057 마법사 상어와 토네이도

    삼성 역량테스트 기출문제

    토네이도 방향으로 돌면서 나아가는 크기와 규칙이 1,1,2,2,3,3,4,4..... 등으로 나아감 => dc
    4개의 방향을 움직일 수 있는 좌표 => dx, dy
    모래가 퍼지는 방향을 4가지 방향의 경우에 맞추어 좌표로 표현해서 배열로 구성 => dsx, dsy

    난이도가 높다기 보다는 빡세게 구현해야 했던 문제

 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20057 {
    static int N;
    static int[][] A;
    static int[] dx = {0,1,0,-1};   //토네이토의 x 이동 방향
    static int[] dy = {-1,0,1,0};   //토네이토의 y 이동 방향
    static int[] dc = {1,1,2,2};   // 토네이도의 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int result = calculate(N/2, N/2);
        System.out.println(result);


        //System.out.println(Arrays.deepToString(A));
    }

    private static int calculate(int x, int y) {

        int totalOutSand = 0;

        int currentX = x;
        int currentY = y;

        while (true) {
            for (int d = 0; d < 4; d++) {
                for (int moveCount = 0; moveCount < dc[d]; moveCount++) {
                    // 현재위치에서 이동
                    int nextX = currentX + dx[d];
                    int nextY = currentY + dy[d];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        return totalOutSand;
                    }

                    // 이동한 위치의 모래 뿌리기
                    int sand = A[nextX][nextY];
                    A[nextX][nextY] = 0;
                    int spreadTotal = 0;


                    for (int spread = 0; spread < 9; spread++) {
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spreadAmount = (sand * sandRatio[spread]) / 100;

                        if (sandX < 0 || sandX >= N || sandY < 0 || sandY >= N) {
                            totalOutSand += spreadAmount;
                        } else {
                            A[sandX][sandY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    // 알파
                    int alphaX = nextX + dx[d];
                    int alphaY = nextY + dy[d];
                    int alphaAmount = sand - spreadTotal;
                    if (alphaX < 0 || alphaX >= N || alphaY < 0 || alphaY >= N) {
                        totalOutSand += alphaAmount;
                    } else {
                        A[alphaX][alphaY] += alphaAmount;
                    }


                    // 이동한 위치를 현재위치로 갱신
                    currentX = nextX;
                    currentY = nextY;
                }
            }

            // 횟수 업데이트
            for (int index = 0; index < 4; index++) {
                dc[index] += 2;
            }
        }

    }
}
