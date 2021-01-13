package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17509 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int v = 0;  // verdict
        int total = 0;  // 총 결과
        int d = 0;  // 풀이시간

        int[][] arr = new int[11][2];

        for(int i=0; i<11; i++) {
           stk = new StringTokenizer(br.readLine());
           arr[i][0] = Integer.parseInt(stk.nextToken());
           arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<11; i++) {
            d += arr[i][0];
            v = arr[i][1];

            total += (d + v*20);
        }
        System.out.println(total);
    }

}
