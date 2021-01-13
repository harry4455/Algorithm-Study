package BJ;/*
    #1074 Z

    분할정복을 활용
    4분면을 기준으로 존재하는 위치로 계속해서 찾아가는 방식을 활용.

    처음에는 크기만큼 배열을 그려주고 하나씩 찾아가야 생각했는데 분할정복이 더 효율적임.

 */
import java.util.Scanner;

public class BJ1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();   // 위치하는 행
        int C = sc.nextInt();   // 위치하는 열

        int n = getSize(N);
        int cnt = 0;
        int x = 0;
        int y = 0;

        while(n > 0) {
            n /= 2;

            if (R < x+n && C < y+n) {   // 왼쪽 위
                cnt += n*n*0;
            } else if (R < x+n) {   // 오른쪽 위
                cnt += n * n * 1;
                y += n;
            } else if (C < y+n){    // 왼쪽 아래
                cnt += n*n*2;
                x += n;
            } else {    // 오른쪽 아래
                cnt += n*n*3;
                x += n;
                y += n;
            }

            if(n == 1) {
                System.out.println(cnt);
                break;
            }
        }
    }

    private static int getSize(int n) {
        int result = 1;
        for(int i=0; i<n; i++)
            result *= 2;
        return result;
    }
}
