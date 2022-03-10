package BJ;

import java.util.Scanner;

public class BJ11726 {
    static int[] Dy;

    public static void main(String[] args) {
        pro();
    }

    private static void pro() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dy = new int[1001];
        Dy[1] = 1;
        Dy[2] = 2;

        for(int i=3; i<=n; i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2]) % 10007;
        }

        System.out.println(Dy[n]);
    }
}
