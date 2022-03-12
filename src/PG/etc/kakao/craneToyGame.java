/**
 * # 크레인 인형뽑기 게임
 *
 * 2019 카카오 개발자 겨울 인턴십 기출
 */

package PG.etc.kakao;

import java.util.Stack;

public class craneToyGame {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        for(int m : moves) {
            boolean flag = false;
            for(int i=0; i< board.length; i++) {
                if(board[i][m-1] != 0 && !flag) {
                    if(!stack.isEmpty()) {
                        int num = stack.peek();
                        if(num == board[i][m-1]) {
                            stack.pop();
                            board[i][m-1] = 0;
                            answer += 2;
                        } else {
                            stack.push(board[i][m-1]);
                            board[i][m-1] = 0;
                        }
                    } else {
                        stack.push(board[i][m-1]);
                        board[i][m-1] = 0;
                    }
                    flag = true;
                }
            }
        }

        return answer;
    }

}
