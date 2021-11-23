package PG.Level2;

import java.util.Arrays;

public class triangleSnail {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] map = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        // 아래 오른쪽 대각선 반복
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i % 3 == 0) {    // 아래
                    x++;
                } else if (i % 3 == 1) {    // 오른쪽
                    y++;
                } else {    // 대각선
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }

        int k=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0) {
                    break;
                }
                answer[k++] = map[i][j];
            }
        }

        return answer;
    }
}
