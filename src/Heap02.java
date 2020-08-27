// 힙(Heap) #2
// 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-Java
/*
Shortest Job First(SJF) 알고리즘을 구현
준비 큐에서 가장 짧은 (CPU 요구량이 가장 적은) 프로세스에게 CPU 할당.
실행전에는 알 수 없고, 지수 평균 방법을 통해 추측

하지만 문제에서는 실행시간(작업시간)에 대해 알려주기 때문에 신경쓸 필요가 없음
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Heap02 {

    private static class Job {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime; // 작업이 요청되는 시점
            this.workingTime = workingTime; // 작업의 소요시간
        }

    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        // 작업시간을 기준으로 오름차순으로 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.workingTime - j2.workingTime;
            }
        });

        // 대기큐에 모든 작업을 넣는다.
        for (int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        // 요청시간을 기준으로 오름차순으로 정렬
        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.requestTime - j2.requestTime;
            }
        });

        int answer = 0;
        int cnt = 0;
        int time = waiting.peek().requestTime;

        while (cnt < jobs.length) {
            // 현재 시간 이하의 요청시간을 가지는 작업을 모두 대기큐에서 작업 큐로 옮긴다.
            while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                pq.offer(waiting.pollFirst());
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll(); // 오름차순으로 정렬 되어 있어서 가장 작업시간이 짧은 작업이 꺼내짐
                time += job.workingTime; // 현재 시간에 현재 작업의 작업시간을 더해줌
                answer += time - job.requestTime; // 총 시간을 구하기 위해 더해나감
                cnt++; // 완료된 작업의 숫자
            } else {
                time++; // 작업 큐가 비었을 경우 시간을 하나씩 더해나감
            }
        }

        return answer / cnt; // 마지막 연산 과정
    }
}
