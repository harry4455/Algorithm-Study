/*
 * # 프린터
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 *
 * 위 3가지 사항을 바탕으로 작성
 */

package PG.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        solution(priorities, location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Task> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int now = 0;
        while(!queue.isEmpty()) {
            Task curr = queue.poll();
            boolean flag = false;
            for(Task t : queue) {
                if(t.priority > curr.priority) {
                    flag = true;
                }
            }
            if(flag) {  // 우선순위 높은게 존재하면 queue의 뒤로 보낸다
                queue.add(curr);
            } else {
                now++;
                if(curr.location == location) {
                    answer = now;
                    break;
                }
            }
        }

        return answer;
    }

    private static class Task {
        int location;
        int priority;
        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}

