package BJ;

import java.util.Scanner;

public class BJ11057 {
    static int N;
    static int[] A;
    static int[][] Dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N+1];
        Dy = new int[N+1][10];

        pro();
    }

    private static void pro() {
        // 초기화
        for(int num=0; num<=9; num++) {
            Dy[1][num] = 1;
        }

        // 점화식을 바탕으로 Dy 배열 채우기
        for(int len = 2; len <= N; len++) {
            for(int num = 0; num <= 9; num++) {
                // 길이가 len이고 num으로 끝나는 갯수를 계산. => Dy[len][num]을 계산
                for(int prev = 0; prev <= num; prev++) {
                    Dy[len][num] += Dy[len-1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        // 정답 출력
        int ans = 0;
        for(int num = 0; num <= 9; num++) {
            ans += Dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);
    }
}
