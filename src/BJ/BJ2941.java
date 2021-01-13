package BJ;

import java.io.*;

public class BJ2941 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int len = word.length();
        int cnt = 0;

        for(int i=0; i<len; i++) {

            char ch = word.charAt(i);

            if(ch == 'c' && i < len-1) {
                if(word.charAt(i+1) == '=' || word.charAt(i+1) == '-') {
                    i++;
                }
            } else if (ch == 'd' && i < len-1) {
                if(word.charAt(i+1) == '-') {
                    i++;
                } else if(word.charAt(i+1) == 'z' && i < len-2) {
                    if(word.charAt(i+2) == '=') {
                        i += 2;
                    }
                }
            } else if ((ch == 'l' || ch == 'n') && i < len-1) {
                if(word.charAt(i+1) == 'j') {
                    i++;
                }
            } else if ((ch == 's' || ch == 'z') && i < len-1) {
                if(word.charAt(i+1) == '=') {
                    i++;
                }
            }

            cnt++;
        }
        System.out.println(cnt);
    }
}
