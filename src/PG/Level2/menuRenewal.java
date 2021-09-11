/*
 * # 메뉴 리뉴얼
 *
 * 2021 카카오 블라인드 코딩테스트 기출문제
 *
 * 구현 문제라고 생각했으나 조금만 살펴보면 용이하게 풀이 가능.
 *
 * 문제에서 주어진 코스의 크기대로 각 경우를 살핀다음에 그 중에서 가장 큰 값을 찾으면 가능.
 * 각 경우마다 찾은 문자열은 우선순위큐에 저장하면 자동으로 사전별 오름차순으로 저장.
 *
 */

package PG.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class menuRenewal {
    static HashMap<String, Integer> map;
    static int m;
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i=0; i<course.length; i++) {
            map = new HashMap<>();
            m = 0;
            for(int j=0; j<orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for(String s : map.keySet()) {
                if(map.get(s) == m && m > 1) {
                    pq.offer(s);
                }
            }
        }

        String[] answer = new String[pq.size()];
        int k=0;
        while(!pq.isEmpty()) {
            answer[k++] = pq.poll();
        }

        return answer;
    }

    private static void find(int cnt, String str, int targetNum, int idx, String word) {
        if(cnt == targetNum) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps = "";
            for(int i=0; i<c.length; i++) {
                temps += c[i];
            }
            map.put(temps, map.getOrDefault(temps, 0)+1);
            m = Math.max(m, map.get(temps));
            return;
        }

        for(int i=idx; i<word.length(); i++) {
            char now = word.charAt(i);
            find(cnt+1, str+now, targetNum, i+1, word);
        }
    }
}
