//https://n1tjrgns.tistory.com/190

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution303 {
    public static void main(String[] args) {

        int[] priorities = new int[]{2,1,3,2};
        int location = 2;

        //solution(properties, location);

        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : priorities) {
            pq.add(i);
            System.out.println(pq);
        }

        System.out.println(pq);
        while(!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == (int) pq.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
