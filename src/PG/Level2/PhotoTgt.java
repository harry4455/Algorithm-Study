/*
 * # 단체사진 찍기
 *
 * 2017 카카오코드 본선 기출
 *
 * DFS로 순열 돌면서 그 속에서 문제속의 조건 부합하는지 찾기
 */
package PG.Level2;

import java.util.HashMap;

public class PhotoTgt {
    static String[] d;
    static HashMap<Character, Integer> map;
    static int answer;
    static boolean[] visited;
    static int[] ch;
    public static void main(String[] args) {

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(solution(n, data));
    }

    public static int solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer = 0;
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        dfs(0);
        return answer;
    }

    private static void dfs(int idx) {
        if(idx == 8) {
            if(check()) answer++;
        } else {
            for(int i=0; i<8; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx+1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check() {
        int a, b, res;
        char op;
        for(String s : d) {
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            if(op == '='){
                if(Math.abs(a-b) != res) return false;
            } else if (op == '>') {
                if(Math.abs(a-b) <= res) return false;
            } else {
                if(Math.abs(a-b) >= res) return false;
            }
        }
        return true;
    }
}
