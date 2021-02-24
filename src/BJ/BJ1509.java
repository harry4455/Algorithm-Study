/*
    #1509 팰린드롬 분할


 */

package BJ;

import java.util.Scanner;

public class BJ1509 {
    public static boolean[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int n = s.length();

        // index 계산을 편하게 하기 위한 방법
        s = " " + s;
        arr = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++) {
            arr[i][i] = true;
        }
        for(int i=1; i<n; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                arr[i][i+1] = arr[i+1][i] = true;
            }
        }

        makeAnswerArr(s, n);

        int[] d = new int[n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j <= i; j++) {
                if(arr[i][j]) {
                    if(d[i] == 0 || d[i] > d[j-1] + 1) {
                        d[i] = d[j-1] + 1;
                    }
                }
            }
        }
        System.out.println(d[n]);
    }

    private static void makeAnswerArr(String s, int n) {
        for(int i=2; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                if(s.charAt(j) == s.charAt(j+i) && arr[j+1][j+i-1]) {
                    arr[j][j+i] = arr[j+i][j] = true;
                }
            }
        }
    }
}
