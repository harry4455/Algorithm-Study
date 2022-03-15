package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ15681 {
    static int N,R,Q;
    static ArrayList<Integer>[] con;
    static int[] Dy;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        con = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            con[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);
        }

        pro();

    }

    private static void pro() {
        Dy = new int[N+1];

        dfs(R, -1);

        for(int i=1; i<=Q; i++) {
            int q = sc.nextInt();
            sb.append(Dy[q]).append('\n');
        }

        System.out.println(sb.toString());
    }

    // Dy[x]를 계산하는 함수
    private static void dfs(int x, int prev) {
        Dy[x] = 1;

        for(int y : con[x]) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }
}
