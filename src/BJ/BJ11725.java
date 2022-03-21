package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ11725 {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList[N+1];

        parent = new int[N+1];

        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();

        for(int i=1; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        pro();
    }

    private static void pro() {
        // root 로 부터 트리의 구조를 파악하는 것으로 시작
        dfs(1, -1);

        // 정답 출력
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb.toString());
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, x의 children을 찾아주는 함수
    private static void dfs(int x, int par) {
        for(int y : list[x]) {
            if(y == par) continue;
            parent[y] = x;
            dfs(y,x);
        }
    }
}
