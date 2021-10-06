/*
 * # 전화번호 목록
 *
 * Hash를 활용하긴 했는데, 의견란에서 이런 문제는 value가 필요없으니 HashMap 보다는 HashSet이 더 낫지 않을까라는 의견을 참고할 수 있었음
 *
 */

package PG.Level2;

import java.util.Arrays;
import java.util.HashMap;

public class phonebookList {
    public static void main(String[] args) {
        //String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"12","123","1235","567","88"};

        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}
