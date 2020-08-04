import java.util.PriorityQueue;
import java.util.Queue;

public class Solution201 {
    public static void main(String[] args) {

        int[] scoville;
        int K = 7;

        scoville = new int[]{1, 2, 3, 9, 10, 12};

        solution(scoville, K);
    }

    public static int solution(int[] scoville, int K) {
        int answer = -1;
        int sco1 = 0, sco2 = 0;
        int temp = 0, times = 0;

        Queue <Integer> pq = new PriorityQueue<Integer>(scoville.length);

        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1){
            if(pq.peek() >= K) {
                answer = times;
                break;
            }
            sco1 = pq.poll();
            sco2 = pq.poll();
            temp = sco1 + (sco2 * 2);
            pq.offer(temp);
            times++;
        }

        // 마지막 큐에 하나 남은 값이 K를 넘는지 확인
        if(pq.poll() >= K){
            answer = times;
        }

        return answer;
    }
}
