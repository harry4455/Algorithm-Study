/*
    #1655 가운데를 말해요

    하나의 힙으로 풀 생각을 했는데
    최대힙과 최소힙을 함께 사용해서 풀면 가능했던 문제

    입력 부분에서 시간 초과가 나서 변경했음 (Scanner -> BufferedReader)

 */
package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }

            //System.out.println(maxHeap.peek());
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
