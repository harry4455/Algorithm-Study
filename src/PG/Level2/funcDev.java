/*
 * # 기능개발
 *
 * 첫 풀이는 배열로 막무가내식이었으나 전체 케이스를 만족하지 못하는 풀이였음
 * 이후, 람다식 풀이를 차용하여 성공
 *
 * 기본적인 풀이 개념은 현재 배열위치로 이후로 100까지의 일정이 작다면 모두 같은 일자에 배포되는 것으로 간주.
 *
 * 작업의 갯수가 100개 뿐이므로 임시로 사용할 배열을 100개의 크기로 활용하여 값을 모두 담아내고
 * 람다식으로 0의 크기 값은 모두 삭제한다.
 */

package PG.Level2;

import java.util.Arrays;
public class funcDev {
    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        //int[] progresses = {93, 30, 55};
        int[] speeds = {1,1,1,1,1,1};
        //int[] speeds = {1,30,5};

        solution(progresses, speeds);
    }


    public static int[] solution(int[] progresses, int[] speeds) {
        int[] DOE = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            DOE[day]++;
        }
        return Arrays.stream(DOE).filter(i -> i!=0).toArray();
    }
}

/*
    내가 풀어본 코드
        int[] answer = {};
        int[] cnt = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            int nums = (100 - progresses[i]) / speeds[i];
            int remains = (100 - progresses[i]) % speeds[i];
            cnt[i] = (remains == 0) ? nums : nums + 1;
        }
        ArrayList<Integer> list = new ArrayList<>();

        int cntNum = 1;
        for(int i=1; i<cnt.length; i++) {
            if(cnt[i] <= cnt[i-1]) {
                cntNum++;
            } else {
                list.add(cntNum);
                cntNum = 1;
            }
            if(i == cnt.length-1) {
                list.add(cntNum);
            }
        }

        int idx = 0;
        answer = new int[list.size()];

        for(int i : list) {
            answer[idx++] = i;
        }

        return answer;
 */
