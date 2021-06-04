package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] chars = new int[26];

        while(N-- > 0) {
            String name = br.readLine();
            char word = name.charAt(0);
            chars[word-97]++;
        }
        boolean flag = false;

        for(int i=0; i<chars.length; i++) {
            if(chars[i] >= 5) {
                flag = true;
                sb.append((char)(i+97));
            }
            if(i == chars.length-1 && !flag) {
                sb.append("PREDAJA");
            }
        }

        System.out.println(sb.toString());
    }
}
