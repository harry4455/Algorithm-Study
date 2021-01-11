import java.io.*;

public class BJ10989 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++) {
            while(arr[i] > 0) {
                sb.append(i).append('\n');
                arr[i]--;
            }
        }

        System.out.println(sb.toString());

    }
}