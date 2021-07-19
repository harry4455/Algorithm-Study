/**
 * #2529 부등호
 *
 * 위상정렬 문제
 * dfs를 활용한 백트랙킹을 진행, 각 단계마다 visited로 방문 여부 확인
 * 조건부에 비교 연산이 맞는지 확인
 * 최종적으로 모든 연산에 부합하여 문자열을 다 채우게 되면 ArrayList에 각 경우를 하나씩 쌓아나감
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2529 {
    static int K;
    static char[] str = new char[10];
    static List<String> ans = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            str[i] = stk.nextToken().charAt(0);
        }

        dfs("", 0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
        br.close();
    }

    private static void dfs(String num, int idx) {
        if(idx == K+1) {
            ans.add(num);
            return;
        }

        for(int i=0; i<=9; i++) {
            if(visited[i]) continue;
            if(idx == 0 || ck(Character.getNumericValue(num.charAt(idx - 1)), i, str[idx - 1])) {
                visited[i] = true;
                dfs(num + i, idx + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean ck(int a, int b, char c) {
        if(c == '<') {
            if(a > b) return false;
        } else if (c == '>') {
            if(a < b) return false;
        }
        return true;
    }
}
