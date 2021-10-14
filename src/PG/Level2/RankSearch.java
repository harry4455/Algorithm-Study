/*
 * # 순위 검색
 * 2021 카카오 블라인드 기출
 *
 * 문제 풀이의 전반적인 프로세스
 *
 * 나올 수 있는 모든 경우의 수를 map에 저장 -> map 안에 저장된 점수를 정렬 -> 정렬된 숫자 내에서 query의 목표 점수와 비교하여 결과 출력
 *
 * 처음에 풀었을 때랑 나중에 다른 버전 참고한거랑 일부 정확성, 효율성에서 차이가 발생했는데
 * 아무래도 HashMap, Map에서의 차이로 보임.
 */

package PG.Level2;

import java.util.*;

public class RankSearch {

    static Map<String, ArrayList<Integer>> map;
    static ArrayList<Integer> in;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        // 1. 모든 경우의 수를 map에 저장
        for (String s : info) {
            dfs("", 0, s.split(" "));
        }

        // 2. map에 저장된 점수 list 오름차순으로 정렬
        List<String> list = new ArrayList<>(map.keySet());
        for (String s : list) {
            List<Integer> scoreList = map.get(s);
            Collections.sort(scoreList);
        }

        // 3. 이진 탐색으로 query의 목표 점수보다 높은 갯수를 세어냄
        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] str = query[i].split(" ");
            int score = Integer.parseInt(str[1]);

            answer[i] = binarySearch(str[0], score);
        }

        return answer;
    }

    private static void dfs(String pos, int depth, String[] info) {
        if(depth == 4) {
            if(!map.containsKey(pos)) {
                in = new ArrayList<>();
                in.add(Integer.valueOf(info[4]));
                map.put(pos, in);
            } else {
                map.get(pos).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(pos + "-", depth+1, info);
        dfs(pos + info[depth], depth+1, info);
    }

    private static int binarySearch(String query, int score) {
        if(!map.containsKey(query)) return 0;
        List<Integer> scoreList = map.get(query);
        int start = 0;
        int end = scoreList.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scoreList.size() - start;
    }

    private static void comb(String str, int depth, String[] arr) {
        if(depth == 4) {
            int score = Integer.parseInt(arr[4]);
            if(map.containsKey(str)) map.get(str).add(score);
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                map.put(str, tmp);
            }
            return;
        }

        // 모든 경우의 수를 조합으로 생성하여 map에서 관리
        comb(str + "-", depth + 1, arr);
        comb(str + arr[depth], depth + 1, arr);
    }


}
