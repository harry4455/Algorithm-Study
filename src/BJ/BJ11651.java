package BJ;

import java.io.*;
import java.util.*;

public class BJ11651 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        String[] num = new String[2];

        for(int i=0; i<N; i++) {
            num = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(num[0]);
            arr[i][1] = Integer.parseInt(num[1]);
        }

        Arrays.sort(arr, new Comparator<int []>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        for(int i=0; i<N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

