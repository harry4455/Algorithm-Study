import java.util.*;
import java.io.*;

public class BJ2693 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                arr[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");

        }
        System.out.println(sb.toString());
    }
}