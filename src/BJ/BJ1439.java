/*
    #1439 뒤집기

    처음에 문제 이해를 좀 잘못한건지
    문제 예시에 숫자 전부다 뒤집는거 때문에 헷갈렸다.

    연속된 숫자들을 하나의 덩어리로 따져서 숫자 한 자리로 치환하여 생각한다음
    0과 1 중에서 작은 것을 선택하면 풀이 완료!
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ch = str.toCharArray();

        int ascii = 48;
        int[] cnt = new int[2];
        char lastCh = ch[0];

        for(int i=1; i<ch.length; i++) {
            if(lastCh != ch[i]) {
                cnt[lastCh - ascii]++;
                lastCh = ch[i];
            }
        }

        //맨 마지막 부분
        cnt[lastCh - ascii]++;

        System.out.println(Math.min(cnt[0], cnt[1]));



    }
}
