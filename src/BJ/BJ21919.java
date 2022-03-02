/*
 * # BJ21919 소수 최소 공배수
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //배열의 길이
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(nums[i], max);
        }
        int[] isPrime = new int[max+1]; //0이면 prime
        isPrime[1] = 1; //1은 소수가 아니다
        long answer = 1;

        for(int i = 2; i*i < isPrime.length; i++){
            if(isPrime[i] == 1) continue;
            for(int j = i*2; j < isPrime.length; j+=i){
                isPrime[j] = 1;
            }
        }

        for (int num : nums) {
            if (isPrime[num] == 1) continue;
            answer *= num;
            isPrime[num] = 1; //같은 수 중복 제거
        }

        System.out.println(answer == 1 ? -1 : answer);
    }
}