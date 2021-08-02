/*
 * #20167 꿈틀꿈틀 호석 애벌레 - 기능성
 *
 * 문제 주어진 조건대로 순차적인 실행 진행
 * 다만, 기능성 테스트이기 때문에 일부 케이스에서 만족하지 못함 (해결필요)
 *
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20167 {
    static int N,K;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0,0,0);

        System.out.println(max);
    }

    private static void dfs(int idx, int eat, int energy) {
        // 마지막 점에 다달았을 때
        if(idx == N) {
            max = Math.max(max, energy);
            return;
        }

        // 그냥 지나친 경우
        dfs(idx+1, eat, energy);


        // 무조건 앞으로 나아가니깐 더해줌
        eat += arr[idx];

        // 축적 에너지가 만족도를 초과할때
        if(eat >= K) {
            energy += (eat - K);
            eat = 0;
        }

        dfs(idx+1, eat, energy);
    }
}
