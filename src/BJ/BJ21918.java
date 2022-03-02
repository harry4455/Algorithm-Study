/*
 * # BJ21918 전구
 */

package BJ;

import java.util.*;

public class BJ21918 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] lightbulb = new int[N];
        for(int i=0; i<N; i++) lightbulb[i] = sc.nextInt();

        for(int i=0; i<M; i++) {
            int commnd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(commnd == 1) {
                lightbulb[a - 1] = b;
            } else {
                for(int j=a; j<=b; j++) {
                    if(commnd == 2) {
                        if(lightbulb[j-1] == 0) {
                            lightbulb[j-1] = 1;
                        } else {
                            lightbulb[j-1] = 0;
                        }
                    } else if(commnd == 3) lightbulb[j-1] = 0;
                    else if(commnd == 4) lightbulb[j-1] = 1;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int k : lightbulb) {
            answer.append(k).append(" ");
        }

        System.out.println(answer);
    }
}
