package PG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution306 {

    public static void main(String[] args) {

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<Integer>();

        int num = 0;
        int len = progresses.length;
        for (int i = 0; i <= len; i++) {
            if (i == len) {
                queue.add(num);
                break;
            }
            if (progresses[i] >= 100) {
                num++;
                continue;
            }
            if (num != 0) {
                queue.add(num);
            }

            num = 0;
            int remain = 100 - progresses[i]; //
            int day = remain / speeds[i]; // 100프로 달성까지 걸리는 일수
            if (remain % speeds[i] != 0) {
                day++;
            }

            for (int j = i; j < len; j++) {
                progresses[j] += (day * speeds[j]);
            }
            num++;
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
