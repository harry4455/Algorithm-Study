/*
 * # 구명보트
 *
 * 탐욕법
 */
package PG.Level2;

import java.util.Arrays;

public class rescueBoat {
    public static void main(String[] args) {

        int[] people = {70,50,80,50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for(int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }


        return answer;
    }
}
