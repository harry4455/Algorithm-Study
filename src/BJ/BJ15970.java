package BJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ15970 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] a;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        a = new ArrayList[N+1];
        for(int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }

        for(int i=1; i<=N; i++) {
            int coord, color;
            coord = sc.nextInt();
            color = sc.nextInt();
            // TODO : color인 색깔의 점이 coord에 놓여 있음
            a[color].add(coord);
        }
        
        pro();
    }

    static void pro() {
        // TODO : 색깔별로 정렬하기
        for(int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for(int color = 1; color <= N; color++) {
            // TODO : 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            for(int i=0; i<a[color].size(); i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);
                ans += Math.min(left, right);
            }
        }

        System.out.println(ans);
    }

    static int toLeft(int color, int idx) {
        // TODO
        // 색깔이 color 인 점의 idx 번째에 있는 점이 왼쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 왼쪽에 점이 없다면 무한대를 return.

        if(idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int toRight(int color, int idx) {
        // TODO
        // 색깔이 color 인 점의 idx 번째에 있는 점이 오른쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 오른쪽에 점이 없다면 무한대를 return.

        if(idx == a[color].size() - 1) return Integer.MAX_VALUE;
        return a[color].get(idx+1) - a[color].get(idx);
    }
}
