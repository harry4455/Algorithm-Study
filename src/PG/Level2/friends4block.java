/*
 * # 프렌즈4블록
 *
 * 같은 크기의 문자열 2차원 배열로 복사해놓은 다음
 * 연산을 진행하며 하나씩 계산하면 끝.
 */

package PG.Level2;

public class friends4block {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution(m,n,board));
    }

    public static int solution(int m, int n, String[] board) {
        // 먼저 문자 2차원 배열로 변환
        char[][] blocks = new char[m][];
        for(int i=0; i<m; i++) {
            blocks[i] = board[i].toCharArray();
        }

        int answer = 0;

        while(true) {
            char[][] nextBlocks = new char[m][];
            for(int i=0; i<m; i++) {
                nextBlocks[i] = blocks[i].clone();
            }

            boolean ck = false;

            for(int i=0; i < m-1; i++) {
                for(int j=0; j < n-1; j++) {
                    if(blocks[i][j] == '.') {
                        continue;
                    }

                    // 같은 문자 있는지 영역탐색
                    if(blocks[i][j] == blocks[i+1][j]
                            && blocks[i][j] == blocks[i][j+1]
                            && blocks[i][j] == blocks[i+1][j+1]) {
                        nextBlocks[i][j] = nextBlocks[i+1][j] = nextBlocks[i][j+1] = nextBlocks[i+1][j+1] = '.';
                        ck = true;
                    }
                }
            }

            // 지워질 블록이 없으면 끝.
            if(!ck) break;

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(blocks[i][j] != nextBlocks[i][j]) answer++;
                }
            }

            // 각 열마다 반복적인 작업
            for(int i=0; i<n; i++) {
                // 맨 아래서부터 blank 탐색
                int blank = m - 1;

                while(true) {
                    while(blank >= 0 && nextBlocks[blank][i] != '.') {
                        blank--;
                    }

                    // 빈 공간을 찾은 경우
                    int block = blank;
                    while(block >= 0 && nextBlocks[block][i] == '.') {
                        block--;
                    }

                    if(block < 0) {
                        break;
                    }

                    // 아래로 끌어 내리는 작업
                    nextBlocks[blank][i] = nextBlocks[block][i];
                    nextBlocks[block][i] = '.';
                }
            }
            blocks = nextBlocks;
        }
        return answer;
    }
}
