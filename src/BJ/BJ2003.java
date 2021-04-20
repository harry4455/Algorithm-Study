package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // 시작점과 끝점을 두고 더해나가면서 진행

        int count = 0; // M이 되는 경우의 수
        int sum = 0;	// 매 회차마다의 합
        int end = 0;	// 꼬리 포인터

        for(int start = 0; start < N; start++) {	// 머리 포인터
            sum += arr[start];

            if(sum == M) {
                // M값이 되면 count 증가, sum에서 end값 위치 빼고 하나 증가
                count++;
                sum -= arr[end++];
            } else if(sum > M) {
                while(sum > M) {
                    sum -= arr[end++];	// sum에서 end값 위치 빼고 하나 증가
                    if(sum == M) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
