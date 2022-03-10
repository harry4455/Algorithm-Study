package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11652 {

    static int N;
    static long[] a;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new long[N+1];

        for(int i=1; i<=N; i++) {
            a[i] = sc.nextLong();
        }

        pro();
    }

    private static void pro() {
        // sort 정렬하기
        Arrays.sort(a, 1, N+1);

        // mode : 최빈값, modeCnt : 최빈값의 등장 횟수, curCnt : 현재 값의 등장 횟수
        long mode = a[1];
        int modeCnt = 1;
        int curCnt = 1;

        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는지, 새로운 숫자가 나왔는지 판단하여 curCnt 갱신, 최빈값 갱신

        for(int i=2; i<=N; i++) {
            if(a[i] == a[i-1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if(modeCnt < curCnt) {
                modeCnt = curCnt;
                mode = a[i];
            }
        }
        // 정답 출력

        System.out.println(mode);

    }
}
