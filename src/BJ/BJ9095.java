package BJ;

import java.util.Scanner;

public class BJ9095 {
    static int[] Dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        preprocess();
        pro();
    }

    private static void pro() {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int n = sc.nextInt();
            sb.append(Dy[n]).append('\n');
        }
        System.out.println(sb);
    }

    private static void preprocess() {
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for(int i=4; i<=11; i++) {
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
        }
    }
}
