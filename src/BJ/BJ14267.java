/*
 #14267 회사 문화 1 (a.k.a. 내리갈굼)
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14267 {
    static int N,M;
    static ArrayList<Integer> adj[];
    static int[] ans;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        adj = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        System.out.println(Arrays.toString(adj));

        weight = new int[N+1];
        ans = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        stk.nextElement();

        for(int i=2; i<=N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            adj[num].add(i);
        }

        System.out.println(Arrays.toString(adj));

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            weight[person] += cost;
        }

        System.out.println(Arrays.toString(weight));

        dfs(1, weight[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int person, int cost) {
        ans[person] += cost;
        for(int i=0; i<adj[person].size(); i++) {
            int next = adj[person].get(i);
            dfs(next, cost+weight[next]);
        }
    }

}
