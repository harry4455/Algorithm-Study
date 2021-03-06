package PG;// 스택/큐 #3

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue01 {

    // truck에 대한 객체 생성(무게와 건너는데 걸리는 시간)
    static class Truck {
        int weight;
        int time;

        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};

        solution(bridge_length, weight, truck_weights);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waiting.offer(new Truck(truck_weights[i], 0));
        }

        int time = 0;
        int totalWeight = 0;
        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;

            if (!bridge.isEmpty()) {
                Truck t = bridge.peek();
                if (time - t.time >= bridge_length) {
                    totalWeight -= t.weight;
                    bridge.poll();
                }
            }

            if (!waiting.isEmpty()) {
                if (totalWeight + waiting.peek().weight <= weight) {
                    Truck t = waiting.poll();
                    totalWeight += t.weight;

                    bridge.offer(new Truck(t.weight, time));
                }
            }
        }
        return time;
    }
}
