package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1949 {
    static int N;
    static int[] num;
    static ArrayList<Integer>[] list;
    static int[][] Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            num[i] = sc.nextInt();
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }

        pro();
    }

    private static void pro() {
        Dy = new int[N+1][N+1];

        dfs(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
    }

    private static void dfs(int x, int prev) {
        Dy[x][0] = 0;
        Dy[x][1] = num[x];

        for(int y : list[x]) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }
    }
}
