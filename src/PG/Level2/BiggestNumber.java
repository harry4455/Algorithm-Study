/*
 * # 가장 큰 수
 *
 * 정렬 문제.. Comparator 활용 방안이 익숙치 않아 참고했슴다
 * 숫자를 문자로 변환하고 서로간의 비교를 통해 정렬을 진행함.
 */

package PG.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) {
        //int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] result = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        System.out.println(Arrays.toString(result));
        System.out.println(result[0]);

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if(result[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        // 정렬된 문자 하나로 합치기

        for(String s : result) {
            answer.append(s);
        }

        return answer.toString();
    }
}
