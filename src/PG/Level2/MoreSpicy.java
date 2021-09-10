/*
 * # 더 맵게
 *
 * 우선순위 큐를 사용하여야만 시간복잡도와 효율성에서 모두 통과 가능
 */

package PG.Level2;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        solution(scoville, K);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int aScoville: scoville) {
            heap.offer(aScoville);
        }

        while(heap.peek() <= K){
            if(heap.size() == 1) {
                return -1;
            }

            int a = heap.poll();
            int b = heap.poll();

            int result = a + (b * 2);

            heap.offer(result);
            answer++;
        }
        return answer;
    }
}
