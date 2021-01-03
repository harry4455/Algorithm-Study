/*
    #8979 올림픽
 */

import java.io.*;
import java.util.StringTokenizer;

public class BJ8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());   // 국가 수
        int K = Integer.parseInt(stk.nextToken());   // 등수

        Country[] countries = new Country[N+1];
        for(int i=1; i<=N; i++) {
            stk = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(stk.nextToken());
            int gold = Integer.parseInt(stk.nextToken());
            int silver = Integer.parseInt(stk.nextToken());
            int bronze = Integer.parseInt(stk.nextToken());
            countries[cnt] = new Country(gold, silver, bronze);
        }
        int result = 1;
        Country k = countries[K];
        for(int i=1; i<=N; i++) {
            Country c = countries[i];
            if(c.gold > k.gold || (c.gold == k.gold && c.silver > k.silver) || (c.gold == k.gold && c.silver == k.silver && c.bronze > k.bronze))
                result++;
        }
        System.out.println(result);
    }

    private static class Country {
        public int gold, silver, bronze;
        public Country(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
