package BJ;

import java.util.*;
import java.io.*;

public class BJ1026 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
            arr2[j] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int s = 0;

        for(int k=0; k<N; k++) {
            s += (arr1[k] * arr2[N-k-1]);
        }

        System.out.println(s);

    }
}