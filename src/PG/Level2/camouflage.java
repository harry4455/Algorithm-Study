/*
 * # 위장
 *
 * 옷 종류별로 서로 조합해서 입는 경우면, 종류마다 곱한다음.. 마지막에 아무것도 안입는 한 경우만 빼주면 가능하다.
 *
 * HashMap에서 종류별로 옷을 세는 경우를 getOrDefault를 통해서
 * key값만 따로 Set로 빼는 것을 keyset으로 활용할 수 있었음.
 */
package PG.Level2;

import java.util.HashMap;
import java.util.Set;

public class camouflage{

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1; // 곱셈을 위해 1로 선언
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
        // map 구하기
        for(int i=0; i<clothes.length; i++) {
            // 의상 종류, 갯수
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        System.out.println(clothesMap);

        // 조합
        Set<String> keySet = clothesMap.keySet();   // 의상 종류

        System.out.println(keySet);

        for(String key : keySet) {
            answer *= clothesMap.get(key) + 1;
        }

        return answer-1;    // 아무것도 안입는 경우의 수 빼기
    }


}
