/*
    #1759 암호만들기

    입력된 문자열을 먼저 오름차순으로 정렬
    그 이후 비어있는 문자열에 0번째 문자 부터 하나씩 차례로 대입하고 길이 L에 도달하면 문제의 조건에 맞는지 확인

    확인하고자 하는 문자열에 새로운 문자를 하나 붙여서 확인하고 그 다음 단계로 넘어감

    확인이 다 끝나면 초반에 설정한 문자열로 돌아와서 다음 문자와의 조합으로 테스트를 진행

    이 과정을 index와 string으로 조합하여 dfs로 풀이
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {
    private static int L,C;
    private static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        arr = br.readLine().split(" ");

        Arrays.sort(arr);

        solve(0, "");
    }

    private static void solve(int idx, String str) {
        if(str.length() == L) { // 길이가 L
            if(isPossible(str)) {   // 모음 하나이상, 자음 2개이상
                System.out.println(str);
            }
            return;
        }
        if(idx >= C) {  // idx값이 맨 끝에 도달했으면 종료
            return;
        }

        solve(idx+1, str + arr[idx]);
        solve(idx+1, str);
    }

    private static boolean isPossible(String str) {
        int vowel = 0;
        int consonant = 0;
        for(int i=0; i<str.length(); i++) {
            if(isVowel(str.charAt(i))) {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >=1 && consonant >= 2;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
