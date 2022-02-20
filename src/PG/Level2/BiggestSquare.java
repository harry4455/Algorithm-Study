/*
 * # 가장 큰 정사각형 찾기
 *
 * bfs, for 문 여러번 돌리며 문제 풀이 해보려 했으나 실패
 * dp 로 문제 풀이
 *
 */


package PG.Level2;

public class BiggestSquare {
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        int sizeRow = board.length;
        int sizeCol = board[0].length;

        int[][] dp = new int[2][sizeCol];

        // 첫번째 줄은 복사 (최댓값은 같이 갱신한다)
        for(int i=0; i<sizeCol; i++) {
            dp[0][i] = board[0][i];

            if(dp[0][i] > answer) {
                answer = dp[0][i];
            }
        }

        for(int i=0; i<sizeRow; i++) {
            for(int j=0; j<sizeCol; j++) {
                if(board[i][j] == 0) {  // 0일 경우
                    dp[1][j] = 0;
                } else {
                    if(j == 0) {    // 0번째 렬일 경우
                        dp[1][j] = 1;
                    } else {
                        dp[1][j] = 1;
                        if(dp[1][j-1] == 0 || dp[0][j] == 0 || dp[0][j-1] == 0) {
                            dp[1][j] = 1;
                        } else if(dp[1][j-1] == dp[0][j] && dp[0][j] == dp[0][j-1]) {
                            dp[1][j] = dp[1][j-1] + 1;
                        } else {    // 셋 다 다르면
                            if(dp[1][j-1] <= dp[0][j-1] && dp[1][j-1] <= dp[0][j]) {
                                dp[1][j] = dp[1][j-1] + 1;
                            } else if(dp[0][j-1] <= dp[1][j-1] && dp[0][j-1] <= dp[0][j]) {
                                dp[1][j] = dp[0][j-1] + 1;
                            } else if(dp[0][j] <= dp[0][j-1] && dp[0][j] <= dp[1][j-1]) {
                                dp[1][j] = dp[0][j] + 1;
                            }
                        }
                    }

                    if(dp[1][j] > answer) {
                        answer = dp[1][j];
                    }
                }
            }
            for (int j = 0; j < sizeCol; j++) {
                dp[0][j] = dp[1][j];
            }
        }

        return answer * answer;
    }
}
