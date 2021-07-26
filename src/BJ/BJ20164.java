/**
 * #20164 홀수 홀릭 호석
 *
 * 3군데로 나눌때 어떻게 해야할지 고민하다가
 * brute-force라는 점을 감안하여 일일히 재귀로 모든 경우 확인함
 *
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20164 {
    static int ansMax = Integer.MIN_VALUE;
    static int ansMin = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        split(num, 0);

        System.out.println(ansMin + " " + ansMax);
    }

    private static void split(String num, int cnt) {
        // 현재 수의 홀수 세기
        cnt += countOdd(num);

        int len = num.length();
        int sum;
        if(len == 1) {
            ansMax = Math.max(ansMax, cnt);
            ansMin = Math.min(ansMin, cnt);
        } else if (len == 2) {
            sum = num.charAt(0) - '0' + num.charAt(1) - '0';
            split(Integer.toString(sum), cnt);
        } else {
            // 3갈래로 잘라서 수를 더한다
            for(int i=1; i<len - 1; i++) {
                for(int j=i+1; j<len; j++) {
                    sum = Sumstr(num.substring(0, i), num.substring(i, j), num.substring(j, len));
                    split(Integer.toString(sum), cnt);
                }
            }
        }
    }

    private static int Sumstr(String str1, String str2, String str3) {
        return Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
    }

    private static int countOdd(String num) {
        int cnt = 0;
        for(int i=0; i<num.length(); i++) {
            if((num.charAt(i) - '0') % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
