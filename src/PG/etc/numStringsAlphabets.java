/*
 * # 숫자 문자열과 영단어
 * 2021 카카오 채용연계형 인턴십 기출
 *
 */

package PG.etc;

public class numStringsAlphabets {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;

        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<10; i++) {
            s = s.replaceAll(word[i], num[i]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
