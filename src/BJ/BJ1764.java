/*
    #1764 듣보잡
    HashSet을 이용해서 풀이
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1764 {
    public static HashSet<String> hs = new HashSet<String>();
    public static ArrayList<String> ans = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        for(int i=0; i<N; i++) {
            hs.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String str = br.readLine();
            if(hs.contains(str)) {
                ans.add(str);
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
