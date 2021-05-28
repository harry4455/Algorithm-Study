/*
    #6550 부분문자열
 */

package BJ;

import java.io.IOException;
import java.util.Scanner;

public class BJ6550 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            String[] word1 = str[0].split("");
            String[] word2 = str[1].split("");

            int x = 0;
            String ans = "Yes";
            for(int i = 0; i < word1.length; i++) {
                boolean run = false;

                for(int j = x; j < word2.length; j++) {
                    if(word1[i].equals(word2[j])) {
                        x = j+1;
                        run = true;
                        break;
                    }
                }

                if(!run) {
                    ans = "No";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}