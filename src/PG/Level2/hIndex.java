/*
 * # H-Index
 *
 * 정렬 후, 규칙에 맞게 고려해서 풀이하면 쉽게 가능.
 */

package PG.Level2;

import java.util.Arrays;

public class hIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
