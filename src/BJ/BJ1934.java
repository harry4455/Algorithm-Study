package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] str;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int min = 0, max = 0, n=1;
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            while(n<=a && n<=b) {
                if(a%n == 0 && b%n == 0) {
                    min = n;
                    n++;
                } else {
                    n++;
                }
            }
            max = (a*b) / min;
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
