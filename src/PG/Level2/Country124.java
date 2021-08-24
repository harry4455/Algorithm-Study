/*
 * # 124 나라의 숫자
 *
 *  처음에는 앞에서 부터 순서대로 나아가려고 했음
 *  최대수가 5억인거 보고 마음 접고 방향 틀음
 *
 *  1,2,4가 각각 반복되며 돌아가는 형태이기에
 *  각자 3을 나눈 나머지를 1,2,0으로 할당하고
 *  주어진 숫자 n을 3으로 계속 나누어가며 나온 나머지를 나중에 한번에 이어가면 완성.
 *
 *  2진법을 구할때와 비슷한 아이디어로 진행하면 비교적 쉽게 풀이 가능.
 */

package PG.Level2;

public class Country124 {
    public static void main(String[] args) {
        int n = 41;
        solution(n);
    }
    public static String solution(int n) {
        String[] numbers = {"4","1","2"};
        String answer = "";

        int num = n;
        while(num > n) {
            int remains = num % 3;
            num /= 3;

            if(remains == 0) num--;

            answer = numbers[remains] + answer;
        }

        return answer;
    }
}
