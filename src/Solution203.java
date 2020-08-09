// 참고 : https://jar100.tistory.com/21
/*
이중순위큐를 연산하는 문제
우선순위큐를 2개 만들어서 오름차순과 내림차순으로 초기화하여 사용
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution203 {
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqmin = new PriorityQueue<>();

        for(String operation : operations) {
            // String을 split 하는 과정
            String[] splitnum = operation.split(" ");

            // 앞글자가 I일 경우 queue에 값을 집어넣음
            if(splitnum[0].equals("I")) {
                pqmax.add(Integer.parseInt(splitnum[1]));
                pqmin.add(Integer.parseInt(splitnum[1]));
            }
            System.out.println("pqmax : " + pqmax);
            System.out.println("pqmin : " + pqmin);

            // 앞글자가 D일 경우 경우에 따라 peek해주는 방식 요구
            if(splitnum[0].equals("D")) {
                if(!pqmax.isEmpty()) {
                    // 큐에서 최댓값을 삭제
                    if(splitnum[1].equals("1")) {
                        int max = pqmax.peek();
                        pqmax.remove(max);
                        pqmin.remove(max);
                    } else {    // 큐에서 최솟값을 삭제
                        int min = pqmin.peek();
                        pqmax.remove(min);
                        pqmin.remove(min);
                    }
                }
            }
        }

        if(!pqmax.isEmpty()) {
            answer[0] = pqmax.peek();
            answer[1] = pqmin.peek();
        }
        return answer;
    }
}
