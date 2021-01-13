package BJ;

import java.util.*;

public class BJ11557 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int max = 0;
            String ans = "";
            for(int i=0; i<N; i++) {
                String line = sc.next();
                int soju = sc.nextInt();
                if(max < soju) {
                    max = soju;
                    ans = line;
                }
            }
            System.out.println(ans);
        }
    }
}