/*
 * # 조이스틱
 *
 * 탐욕법을 활용해서 풀이.
 *
 *
 */

package PG.Level2;

public class joystick {
    public static void main(String[] args) {
        //String name = "JEROEN";
        String name = "JAN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 좌우이동에서 최단 거리는 한번에 끝까지 쭉 가는 경우
        int min = len - 1;

        for(int i=0; i<len; i++) {
            char c = name.charAt(i);
            int mov = Math.min(c - 'A', 'Z' - c + 1);   // 알파벳 위치에서 A,Z 각각으로의 까지 거리 증 최소
            answer += mov;

            // 조이스틱 좌,우 이동
            int nextIdx = i + 1;
            // 다음단어가 A이고, 단어가 끝나기 전까지 nextIdx 증가
            while(nextIdx < len && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            min = Math.min(min, (i * 2) + len - nextIdx);
        }
        answer += min;
        return answer;
    }
}
