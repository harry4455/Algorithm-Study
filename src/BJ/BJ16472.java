package BJ;

import java.util.Scanner;

public class BJ16472 {
    static int N, kind;
    static String str;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        str = sc.next();
        cnt = new int[26];

        solution();
    }

    private static void solution() {
        int answer = 0;

        for(int R=0, L=0; R < str.length(); R++) {
            // R번째 문자 추가
            add(str.charAt(R));

            // 불가능하다면 가능할 때 까지 L 이동
            while(kind > N) {
                erase(str.charAt(L++));
            }

            answer = Math.max(answer, R - L + 1);
        }
        System.out.println(answer);
    }

    private static void erase(char x) {
        cnt[x - 'a']--;
        if(cnt[x - 'a'] == 0) {
            kind--;
        }
    }

    private static void add(char x) {
        cnt[x - 'a']++;
        if(cnt[x - 'a'] == 1) {
            kind++;
        }
    }
}
