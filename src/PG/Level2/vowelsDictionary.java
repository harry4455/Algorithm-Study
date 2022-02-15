/*
 * # 모음 사전
 *
 */
package PG.Level2;

public class vowelsDictionary {
    public static void main(String[] args) {
        String word = "AAAAE";

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;
        int mul = 781;

        // A E I O U
        char[] c = {'A', 'E', 'I', 'O', 'U'};

        for(int i=0; i<word.length(); i++) {
            for(int j=0; j<5; j++) {
                if (c[j] == word.charAt(i)) {
                    answer += 1 + j * mul;
                }
            }
            mul = (mul - 1) / 5;
        }
        return answer;
    }
}
