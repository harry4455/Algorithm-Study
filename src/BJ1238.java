import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        boolean[] charArr = new boolean[52];

        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }

        // 65-90 대문자
        // 97-122 소문자
        // 총 52개

        


    }
}
