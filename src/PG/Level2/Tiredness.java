/*
 * # 피로도
 */

package PG.Level2;

import java.util.HashSet;
import java.util.Set;

public class Tiredness {

    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        solution(k, dungeons);
    }

    static int answer = 0;
    public static int solution(int k, int[][] dungeons) {
        solve(k, dungeons, 0);
        return answer;
    }

    public static void solve(int k, int[][] dungeons, int depth) {
        int n = dungeons.length;
        answer = Math.max(answer, depth);
        for(int i=0; i<n; i++) {
            int[] d = dungeons[i];
            String key = makeKey(d);
            if(!visited.contains(key) && k >= d[0]) {
                visited.add(key);
                solve(k - d[1], dungeons, depth + 1);
                visited.remove(key);
            }
        }
    }

    public static String makeKey(int[] d) {
        return d[0] + "&" + d[1];
    }
}
