package BJ;

import java.util.*;

public class BJ1094 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int len = 64;
        int cnt = 0;
        int result = 0;
        int goal = X;

        while(true) {
            if(X == 64) {
                cnt++;
                break;
            }

            len /= 2;

            if(X >= len) {
                result += len;
                cnt++;
                if(result == goal)
                    break;
                X -= len;
            }
        }
        System.out.println(cnt);
    }
}
