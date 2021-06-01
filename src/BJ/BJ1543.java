package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine());
        //String word = br.readLine();
        String part = br.readLine();

        int cnt = 0;
        int startIdx = 0;
        int len = part.length();

        while((startIdx = sb.toString().indexOf(part)) != -1) {
            sb.delete(0, startIdx + len);
            cnt++;
        }

        System.out.println(cnt);
    }
}
