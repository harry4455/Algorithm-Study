/**
 * # 리틀 프렌즈 사천성
 *
 * 2017 카카오코드 본선
 *
 * 가로, 세로 한번에 이동할 수 있는 경우와
 * 가로-세로, 세로-가로 세트로 한번에 이동할 수 있는 경우의 수를 모두 따져야함
 * 매칭해야하는 알파벳은 순차별로 진행되어야 하므로 list에 먼저 저장하고 정렬해서 순서를 정한다
 */

package PG.etc.kakao;

import java.util.*;

class littleFriendsFourCastle {
    static char[][] b;
    static int m, n;
    static LinkedList<Character> list = new LinkedList<Character>();
    static HashMap<Character, int[][]> map = new HashMap<>();

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        String[] board = {"DBA", "C*A", "CDB"};

        System.out.println(solution(m,n,board));
    }

    public static String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();

        b = new char[m][n];

        //*:42, .:46
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i].charAt(j);
                b[i][j] = c;
                if(c != '.' && c != '*'){
                    if(!list.contains(c)){
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    }
                    else{
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }

        Collections.sort(list);

        int idx = 0;
        while(list.size() != 0){
            if(canDelete(list.get(idx))){
                char popped = list.remove(idx);
                answer.append(popped);
                deleteChar(popped);
                idx = 0;
            }
            else{
                idx++;
                if(idx == list.size()){
                    return "IMPOSSIBLE";
                }
            }
        }

        return answer.toString();
    }

    static void deleteChar(char a){
        b[map.get(a)[0][0]][map.get(a)[0][1]] = '.';
        b[map.get(a)[1][0]][map.get(a)[1][1]] = '.';
    }

    static boolean canDelete(char a){
        int r1 = map.get(a)[0][0];
        int c1 = map.get(a)[0][1];
        int r2 = map.get(a)[1][0];
        int c2 = map.get(a)[1][1];

        if(c1 < c2){
            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
                return true;
            }
            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
                return true;
            }
        }else{
            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
                return true;
            }
            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
                return true;
            }
        }

        return false;
    }

    static boolean linearRowCheck(int r1, int r2, int c, char a){
        for(int i = r1; i < r2+1; i++){
            if(b[i][c] != '.' && b[i][c] != a)
                return false;
        }
        return true;
    }

    static boolean linearColumnCheck(int c1, int c2, int r, char a){
        for(int i = c1; i < c2+1; i++){
            if(b[r][i] != '.' && b[r][i] != a)
                return false;
        }
        return true;
    }
}