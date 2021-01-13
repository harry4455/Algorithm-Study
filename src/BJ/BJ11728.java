package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        int[] arr = new int[N+M];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++) {
            B[j] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i=0, j=0, k=0;
        while(i < N && j < M ) {
            if(A[i] > B[j]) {
                arr[k++] = B[j++];
            } else {
                arr[k++] = A[i++];
            }
        }

        while(j < M) {
            arr[k++] = B[j++];
        }

        while(i < N) {
            arr[k++] = A[i++];
        }

        StringBuilder sb = new StringBuilder();

        for (int value : arr) {
            sb.append(value).append(" ");
        }

        System.out.println(sb.toString());

    }
}
