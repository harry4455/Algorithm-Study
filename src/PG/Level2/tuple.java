/*
 * # 튜플
 * 2019 카카오 개발자 겨울 인턴십
 *
 * 배열 정렬에 조건 걸어서 순서 정하고, ArrayList에 원소값 하나씩 추가
 * Set.add로 HashSet에 기존에 원소값이 추가되었는지 확인하는 방법도 있더라. 한줄로 구현 가능.
 */

package PG.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tuple {
    public static void main(String[] args) {
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        s = s.substring(2, s.length()-2).replace("},{", "-");
        System.out.println(s);

        String[] tuples = s.split("-");
        System.out.println(Arrays.toString(tuples));

        Arrays.sort(tuples, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for(String tmp: tuples) {
            String[] val = tmp.split(",");

            for(int i=0; i<val.length; i++) {
                int num = Integer.parseInt(val[i]);

                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
