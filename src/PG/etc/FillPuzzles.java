/*
 * # 퍼즐 조각 채우기
 * 위클리 챌린지
 *
 * 믿거나~말거나~ 2021 네이버 상반기 채용 4번 문제랑 유사하대요~
 *
 * 빡세게 구현하는 문제.. 몇 가지 방법을 시도했으나 마지막에 블로그를 참고해서 풀이 완성함.
 */

package PG.etc;

import java.util.*;

public class FillPuzzles {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visitBoard;
    static boolean[][] visitTable;
    static int len;

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        len = game_board.length;
        visitBoard = new boolean[len][len];
        visitTable = new boolean[len][len];

        // game_board에서 빈 공간을 추출
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(game_board[i][j] == 1 || visitBoard[i][j]) { // 빈공간이 아니거나 이미 방문한 경우
                    continue;
                }

                // 빈 공간이 존재하면 bfs로 해당 공간의 좌표를 찾아 클래스 생성 후 리스트로 변환
                // 좌표 리스트를 가지고 2차원 배열에 그려준다 (0,0 부터 시작)
                List<Position> emptyCoord = extractBlock(game_board, new Position(i, j), true);
                int[][] empty = makeBlock(emptyCoord);

                // table에서 블록 영역 추출
                match:
                for(int k=0; k<len; k++) {
                    for(int l=0; l<len; l++) {
                        if(table[k][l] == 0 || visitTable[k][l]) {
                            continue;
                        }

                        // 블록 영역의 좌표(Position)를 가지는 리스트 변환
                        List<Position> blockCoord = extractBlock(table, new Position(k,l), false);

                        // '빈 영역' 과 '블럭' 의 좌표 갯수가 다르면 스킵
                        if(emptyCoord.size() != blockCoord.size()) continue;

                        // 블록 좌표 리스트를 가지고 2차원 배열에 그려준다
                        // row, col 길이를 따로 뽑아주는 이유는 블록 회전시 2차원 배열에 0,0 부터 그리기 위함
                        int[][] block = makeBlock(blockCoord);
                        int row = blockCoord.get(0).maxX - blockCoord.get(0).minX + 1;  // 블럭 행의 길이
                        int col = blockCoord.get(0).maxY - blockCoord.get(0).minY + 1;  // 블럭 열의 길이

                        // 빈 영역과 블럭 모양 확인
                        for(int z=0; z<4; z++) {
                            // 모양이 동일할 경우 table에서 해당 영역은 0으로 지워준다.
                            if(isSame(empty, block)) {
                                for(int x=0; x<blockCoord.size(); x++) {
                                    Position rollback = blockCoord.get(x);
                                    table[rollback.x][rollback.y] = 0;
                                }
                                answer += blockCoord.size();
                                break match;
                            }

                            // 매칭이 안된 경우
                            // row, col 길이를 swap하는 이유는 90 회전시, 행/열 길이가 바뀌기 때문에 2차원 배열 0,0 부터 그리기 위함
                            block = rotateBlock(block, row, col);
                            int tmp = row;
                            row = col;
                            col = tmp;
                        }
                    }
                }

                visitTable = new boolean[len][len];
            }
        }
        return answer;
    }

    private static int[][] rotateBlock(int[][] block, int row, int col) {
        int[][] tmpBlock = new int[len][len];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                tmpBlock[j][row - 1 - i] = block[i][j];
            }
        }
        return tmpBlock;
    }

    private static boolean isSame(int[][] empty, int[][] block) {
        for(int i=0; i < empty.length; i++) {
            for(int j=0; j < empty[0].length; j++) {
                if(block[i][j] != empty[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] makeBlock(List<Position> list) {
        int[][] result = new int[len][len];
        int minX = list.get(0).minX;
        int minY = list.get(0).minY;

        int emptyBlockSize = list.size();
        for (Position p : list) {
            result[p.x - minX][p.y - minY] = 1;
        }

        return result;
    }

    private static List<Position> extractBlock(int[][] board, Position p, boolean isBoard) {
        int boardSize = board.length;
        List<Position> list = new ArrayList<>();
        Queue<Position> queue = new LinkedList<>();

        queue.offer(p);

        if(isBoard) {
            visitBoard[p.x][p.y] = true;
        } else {
            visitTable[p.x][p.y] = true;
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            Position start = queue.poll();
            list.add(start);
            minX = Math.min(start.x, minX);
            minY = Math.min(start.y, minY);
            maxX = Math.max(start.x, maxX);
            maxY = Math.max(start.y, maxY);

            for(int i=0; i<4; i++) {
                int row = start.x + dx[i];
                int col = start.y + dy[i];

                if(row < 0 || col < 0 || row > boardSize - 1 || col > boardSize - 1) continue;

                if(isBoard) {
                    if(board[row][col] == 1 || visitBoard[row][col]) continue;
                    visitBoard[row][col] = true;
                } else {
                    if(board[row][col] == 0 || visitTable[row][col]) continue;
                    visitTable[row][col] = true;
                }

                queue.offer(new Position(row, col));
            }
        }

        list.get(0).minX = minX;
        list.get(0).minY = minY;
        list.get(0).maxX = maxX;
        list.get(0).maxY = maxY;

        return list;
    }

    private static class Position {
        int x;
        int y;
        int minX;
        int minY;
        int maxX;
        int maxY;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
