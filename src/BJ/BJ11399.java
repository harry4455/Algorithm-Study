/*
    #11399 ATM

    오름차순으로 해야 당연히 최소시간이 되고
    거기서 배열 합산으로 더해서 나가는 반복문 사용

    사람의 수가 1000 이하라서 Arrays.sort 정렬을 활용해도 시간 초과가 나지 않은 듯함.
 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arrSum = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
        arrSum[0] = arr[0];
        int sum = arrSum[0];

        for(int i=1; i<N; i++) {
            arrSum[i] = arrSum[i-1] + arr[i];
            sum += arrSum[i];
        }

        System.out.println(sum);
    }
}
