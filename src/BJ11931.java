import java.util.*;
import java.io.*;

public class BJ11931 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb.toString());

    }
}