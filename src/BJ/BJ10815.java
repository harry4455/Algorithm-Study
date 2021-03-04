/*
    #10815 숫자 카드

    맨 처음에 하나씩 비교해야 하나 고민하다가

    먼저 상근이가 입력한 배열을 정렬하고
    그 다음으로 비교하기 위해 입력하는 배열의 숫자들을 하나씩 기존의 배열과 비교하며 판별해나간다.
    비교시에 하나씩 비교하면 시간 초과가 날꺼기에 (배열 길이가 50만임...)
    이분 탐색으로 보다 빠르게 비교하며 결과를 찾아나간다.
 */

package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10815 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // arr 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(binarySearch(num)) bw.write("1 ");
            else bw.write("0 ");
        }
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = N-1;

        while(leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = arr[midIndex];

            if(num < mid) rightIndex = midIndex - 1;
            else if(num > mid) leftIndex = midIndex + 1;
            else return true;
        }
        return false;
    }
}
