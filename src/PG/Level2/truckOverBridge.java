/*
 * # 다리를 지나는 트럭
 *
 * queue를 활용해서 쉽게 풀이 가능.
 */

package PG.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class truckOverBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 다리위에 올라가있는 것들을 큐로 생각
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;    // 다리위에 총합
        int time = 0;   // 소요되는 시간

        for(int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                // 다리위에 아무 차량도 없을때
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    // 다리위에 차량이 꽉 차있을때
                    sum -= queue.poll();
                } else {
                    // 나머지 경우
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        // 다음 차례로 올라올 차량까지 포함하면 한계보다 무거울때
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 차량에서 시간이 끝나는데, 그 차량이 다리를 다 지나갈때 까지 시간 추가로 더해줌
        return time + bridge_length;
    }
}
