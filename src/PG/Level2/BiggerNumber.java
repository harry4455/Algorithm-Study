/*
 * # 큰 수 만들기
 *
 * 탐욕법을 활용한 풀이? 약간 프로세스가 잘 이해가 안감.
 * Stack으로 풀이한 예시 있는데, LIFO를 제대로 활용한 예시.
 */
package PG.Level2;

public class BiggerNumber {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int cnt = number.length() - k;
        int left = 0;
        int right = number.length() - cnt;
        int max = -1;
        int idx = 0;

        while(cnt > 0) {
            max = -1;
            for(int j=left; j<=right; ++j) {
                int num = number.charAt(j) - '0';
                System.out.println("num " + num);
                if(num > max) {
                    idx = j;
                    max = num;
                }
            }
            sb.append(number.charAt(idx));
            left = idx + 1;
            right = number.length() - --cnt;
        }

        return sb.toString();
    }
}
