/*
 * # 신고 결과 받기
 *
 * 2021 카카오 블라인드 채용 기출
 */

package PG.etc;

import java.util.*;

public class getReportResult {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String, Integer> result = new LinkedHashMap();
        Map<String, ArrayList<String>> reportMap = new HashMap<>();

        for(int i=0; i<id_list.length; i++) {
            result.put(id_list[i], 0);
        }

        for(int i=0; i<report.length; i++) {
            String[] r = report[i].split(" ");
            String reporter = r[0];   // 신고한사람
            String target = r[1];     // 신고당한사람

            // 신고 당한 사람 기준으로 세어나가기
            if(reportMap.containsKey(target)) {
                reportMap.get(target).add(reporter);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(reporter);
                reportMap.put(target, list);
            }
        }

        for(String key : reportMap.keySet()){
            if(reportMap.get(key).size() >= k) {
                for(String i : reportMap.get(key)){
                    result.put(i, result.getOrDefault(i,0) + 1);
                }
            }
        }

        return result.values().stream().mapToInt(Integer::intValue).toArray();
    }
}

