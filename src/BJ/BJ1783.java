package BJ;

import java.util.*;

public class BJ1783 {
    static int N,M;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();     // 세로
        M = sc.nextInt();     // 가로

        System.out.println(solve());
    }

    static int solve(){
        if(N == 1) return 1;
        if(N == 2) return Math.min(4, (M+1)/2);
        if(M < 7)  return Math.min(4, M);
        return M -2;
    }
}