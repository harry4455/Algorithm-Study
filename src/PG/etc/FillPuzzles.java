/*
 * # 퍼즐 조각 채우기
 * 위클리 챌린지
 *
 * 믿거나~말거나~ 2021 네이버 상반기 채용 4번 문제랑 유사하대요~
 *
 */

package PG.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FillPuzzles {
    static int len, count;
    static int[][] g,t,tmp; //g : game_board, t : table
    static int[] p =new int[2]; // 빈칸과 블록의 가장 작은 x 값과 y값 -> x,y 값 부터 6x6행렬로 오려내기 위함
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; // 빈칸과 블록을 뽑아내기 위해 상하좌우를 정의할 배열
    static List<Block> blankList = new ArrayList<Block>();
    static List<Block> tableList = new ArrayList<Block>();

    private static class Block {   // 빈칸과 블록을 담기 위한 개체 정의
        public int[][] arr;     // 배열을 담음
        public Integer n;       // 빈칸 혹은 블록의 갯수
        Block(int[][] a, int n, int x, int y) {
            arr = new int[6][6];    // 빈칸과 블록의 갯수는 최대 6개 이므로 6*6 배열로 구성
            for(int i=0; i<6; i++) {
                for(int j=0; j<6; j++) {
                    if(x+i < len && y+j < len) {
                        arr[i][j] = a[x+i][y+j];
                    }
                }
            }
            this.n = n;
        }
    }

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        len  = game_board.length;
        g = new int[len][len];
        t = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                g[i][j] = game_board[i][j];
                t[i][j] = table[i][j];
            }
        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(g[i][j] == 0) {
                    tmp = new int[len][len];    // 빈 공간을 복사할 배열
                    p[0] = i;
                    p[1] = j;
                    count = 0;
                    findBlock(i,j,0);
                    blankList.add(new Block(tmp, count, p[0], p[1]));    // 찾은 빈 공간 리스트에 추가
                }
                if(t[i][j] == 1) {              // 블록 발생
                    tmp = new int[len][len];    // 블록을 복사할 배열
                    p[0] = i;
                    p[1] = j;
                    count = 0;
                    findBlock(i,j,1);
                    if(count<=6) tableList.add(new Block(tmp, count, p[0], p[1]));  //찾은 블록 리스트에 추가
                }
            }
        }

        // 공간 수가 많은 것 부터 오름차순
        blankList.sort((o1, o2) -> (o2.n).compareTo(o1.n));
        // 블록 수가 많은 것 부터 오름차순
        tableList.sort((o1, o2) -> (o2.n).compareTo(o1.n));

        for (Block o1 : blankList) {
            for (int j = 0; j < tableList.size(); j++) {
                Block o2 = tableList.get(j);
                if (o1.n < o2.n) {
                }   // 빈 공간보다 블록수가 더 많다면 다음 블록 탐색
                else if (o1.n.equals(o2.n)) {     // 빈 공간 갯수와 블록수가 같은 경우 모양 확인
                    if (fitBlock(o1.arr, o2.arr, o1.n)) {    // 블록이 빈 공간에 딱 들어갈 경우
                        answer += o1.n;
                        tableList.remove(j);
                        break;
                    }
                } else {
                    break;  // 빈 공간의 수가 더 많을 경우 다음 빈공간 탐색
                }
            }
        }
        return answer;
    }

    private static boolean fitBlock(int[][] o1, int[][] o2, int n) {
        int cnt;    //빈 공간에 블록이 위치하면 cnt++
        int[] degree = {0,90,180,270};  // 회전각
        for(int r=0; r<4; r++) {
            int[][] rotate = rotateArr(o2, degree[r]);  // 회전된 배열 반환
            for(int x=0; x<6; x++) {    // rotate 배열의 시작점을 배정
                for(int y=0; y<6; y++) {
                    cnt = 0;
                    for(int i=0; i<6; i++) {
                        for(int j=0; j<6; j++) {
                            if(0 <= x+i && x+i < 6 && 0 <= y+j && y+j < 6) {
                                if(o1[i][j] == 1 && rotate[x+i][y+j] == 1) cnt++;
                                if((o1[i][j] == 1 && rotate[x+i][y+j] == 0) || (o1[i][j] == 0 && rotate[x+i][y+j] == 1)) {
                                    // 맞지 않는 모양일 경우
                                    // 강제 break 걸기
                                    i = 7;
                                    j = 7;
                                }
                            }
                        }
                    }
                    if(cnt == n) return true;   // 딱 맞는 모양일 경우 true 반환
                }
            }
        }
        return false;
    }

    private static int[][] rotateArr(int[][] arr, int degree) {   // 회전 각에 따른 결과를 배열로 반환
        int[][] rotate = new int[6][6];
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                // 정체를 파악하기!!!!!
                switch (degree) {
                    case 0:
                        rotate[i][j] = arr[i][j];
                        break;
                    case 90:
                        rotate[i][j] = arr[5 - i][j];
                        break;
                    case 180:
                        rotate[i][j] = arr[5 - i][5 - j];
                        break;
                    case 270:
                        rotate[i][j] = arr[i][5 - j];
                        break;
                }
            }
        }
        return rotate;
    }

    // 빈 공간 혹은 블록의 모양을 탐색
    //choice 0:빈 공간 찾기 1:블록 찾기
    private static void findBlock(int i, int j, int choice) {
        count++;
        if(choice == 0) {
            g[i][j] = 1;
        } else {
            t[i][j] = 0;
        }

        if(i < p[0]) p[0] = i;
        if(j < p[1]) p[1] = j;

        tmp[i][j] = 1;
        for(int z=0; z<4; z++) {    // dfs로 모양을 탐색
            int x = i + dx[z];
            int y = j + dy[z];
            if(x>=0 && y>=0 && x<len && y<len) {
                if(choice == 0 && g[x][y] == 0) findBlock(x,y,choice);
                if(choice == 1 && t[x][y] == 1) findBlock(x,y,choice);
            }
        }
    }


}
