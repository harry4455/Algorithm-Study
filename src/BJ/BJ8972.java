package BJ;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ8972 {
    // 1하좌, 2하, 3하우, 4좌, 5그대로, 6우, 7상좌, 8상, 9상우
    static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int R,C;
    static Point8972 myArduino;
    static char[][] board;
    static LinkedList<Point8972> crazyArduino = new LinkedList<>();
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        board = new char[R][C];

        for(int i=0; i<R; i++) {
            String str = sc.next();
            for(int j=0; j<C; j++){
                board[i][j] = str.charAt(j);

                if(board[i][j] == 'I') {
                    myArduino = new Point8972(i, j);
                } else if (board[i][j] != '.') {
                    Point8972 p = new Point8972(i, j);
                    crazyArduino.add(p);
                }
            }
        }

        // 움직이려는 방향
        int[] dir = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();

        int kraj = 0;   // 게임이 끝나기 전까지 이동한 횟수

        // game START!!
        for(int i=0; i<dir.length; i++){
            // 1. 내 아두이노 이동
            if(dir[i] != 5) {
                if(!moveMyArduino(dir[i] - 1)) {
                    kraj = i+1;
                    break;
                }
            }

            // 2. 미친 아두이노 이동
            if(!moveCrazyArduino()) {
                kraj = i+1;
                break;
            }

            // 3. 보드 새로 구성하기 (이동간 결과에 따라 보드 새로 그리기)
             makeBoard();
        }

        if(kraj != 0) {
            System.out.println("kraj " + kraj);
        } else {
            print();
        }
    }

    // 1. 내 아두이노 이동
    private static boolean moveMyArduino(int i) {
        int nx = myArduino.x + dx[i];
        int ny = myArduino.y + dy[i];

        if(board[nx][ny] == 'R') {
            return false;
        } else {
            myArduino.x = nx;
            myArduino.y = ny;
            return true;
        }
    }

    // 2. 미친 아두이노 이동
    private static boolean moveCrazyArduino() {
        int[][] tmp = new int[R][C];

        int size = crazyArduino.size();
        for(int i=0; i<size; i++){
            int x = crazyArduino.peek().x;
            int y = crazyArduino.peek().y;

            // 내 아두이노와 가장 가까운 방향을 구하는 변수
            int min = Integer.MAX_VALUE;
            int minX = 0;
            int minY = 0;

            // 8방향 모두 돌려봄
            for(int j=0; j<9; j++) {
                if(j == 4) continue;    // 그대로인 경우

                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                int val = Math.abs(myArduino.x - nx) + Math.abs(myArduino.y - ny);
                if(val < min) {
                    min = val;
                    minX = nx;
                    minY = ny;
                }
            }

            // 이동할 방향에 내 아두이노가 있으면 게임 종료
            if(minX == myArduino.x && minY == myArduino.y) {
                return false;
            }

            tmp[minX][minY] += 1;       // 이동할 수 있다면 +1
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++){
                if(tmp[i][j] == 1) {    // 칸에 1개의 아두이노만 있어야 파괴되지 않음
                    crazyArduino.add(new Point8972(i, j));  // 칸에 아두이노가 1개 있다면 다시 리스트에 명단 추가
                }
            }
        }

        return true;
    }

    // 3. 보드 새로 구성하기
    private static void makeBoard() {
        board = new char[R][C];

        for(int i=0; i<R; i++) {
            Arrays.fill(board[i], '.'); // ,로 배열 초기화
        }

        board[myArduino.x][myArduino.y] = 'I';      // 내 아두이노 위치 입력

        for(int i=0; i<crazyArduino.size(); i++){
            Point8972 p = crazyArduino.poll();
            board[p.x][p.y] = 'R';
            crazyArduino.add(p);
        }
    }

    private static void print() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

class Point8972 {
    int x;
    int y;

    Point8972(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

