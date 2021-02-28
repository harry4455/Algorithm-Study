/*
    #1525 퍼즐

    bfs를 활용한 풀이.
    2차원 배열에서 직접 교환하는 연산을 하기에 복잡해서
    9개의 숫자를 1차원의 숫자로 나열하여 하나씩 확인
    숫자를 교환하는 횟수는 Map을 통해 key, value로 관리하며 확인해 나간다.

 */

package BJ;

import java.util.*;

public class BJ1525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int k = sc.nextInt();
                // 0은 9로 바꿔서 표현
                if(k == 0) {
                    k = 9;
                }
                // 2차원의 배열을 하나의 정수로 표현
                start = (start * 10) + k;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        map.put(start, 0);
        queue.add(start);
        System.out.println(map);
        System.out.println(queue);

        while(!queue.isEmpty()) {
            int nowNum = queue.poll();
            String now = String.valueOf(nowNum);
            int nine = now.indexOf("9"); // 9의 인덱스
            int x = nine / 3;   // 몇 번째 행인지 계산
            int y = nine % 3;   // 몇 번째 열인지 계산
            for(int i=0; i<4; i++) {
                int nx = x + dx[i]; // 이동할 상하좌우 행 계산
                int ny = y + dy[i]; // 이동할 상하좌우 열 계산
                int move = nx*3 + ny; // 이동할 상하좌우의 1차원 배열에서의 위치(index)
                if(nx >=0 && nx < 3 && ny >= 0 && ny < 3) {
                    StringBuilder next = new StringBuilder(now);
                    // 9와 위치 변경할 숫자 바꿔주기
                    char temp = next.charAt(move);
                    next.setCharAt(move, '9');  // 이동할 자리에 9 놓기
                    next.setCharAt(nine, temp);     // 원래 9가 있던 자리에 이동할 수를 놓기
                    int nextNum = Integer.parseInt(next.toString());
                    // 몇 번 이동했는지 map에 저장
                    if(!map.containsKey(nextNum)) {
                        map.put(nextNum, map.get(nowNum) + 1);
                        queue.add(nextNum);
                    }

                }
            }
        }

        System.out.println(map);

        if(map.containsKey(123456789)) {
            System.out.println(map.get(123456789));
        } else {
            System.out.println(-1);
        }
    }
}
