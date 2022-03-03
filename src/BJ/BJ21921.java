package BJ;

import java.util.*;
import java.io.*;

public class BJ21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N+1];
        stk = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            if(i <= X) sum += arr[i];
        }

        int max_sum = sum;
        int cnt = 0;

        //window sliding
        int left = 1;
        int right = X;
        while(true) {
            left++;
            right++;
            if(right > N) break;
            sum = sum + arr[right] - arr[left - 1];
            if(max_sum == sum) {
                cnt++;
            } else if(max_sum < sum) {
                max_sum = sum;
                cnt = 1;
            }
        }

        if(max_sum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max_sum);
            System.out.println(cnt);
        }
    }
}