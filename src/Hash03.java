// 해시 문제 #3

import java.util.HashMap;

public class Hash03 {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 배열 돌면서 value 기준으로 의상마다 몇개인지 세기
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
            /*System.out.println(map.get(clothe[1]));
            System.out.println(map.getOrDefault(clothe[1], 0));*/
        }

        // 각 key마다 value 갯수로 for문 돌면서 연산하기
        // 각 인자마다 1씩 더해서 서로 곱해주면 완성.
        int answer = 1;
        for (String key : map.keySet()) {
            System.out.println(map.keySet());
            System.out.println(key);
            /*System.out.println(key);
            System.out.println(map.get(key));*/
            answer *= map.get(key) + 1;
            //System.out.println(answer);
        }
        // 마지막에 1빼줘야댐,,,, 이게 조합 공식
        return answer - 1;
    }

}
