/*
 * # 후보키
 *
 * 2019 카카오 기출
 */

package PG.Level2;

import java.util.*;

public class candidateKey {

    // 모든 후보키 조합 저장
    public static ArrayList<String> list = new ArrayList<>();
    // 유일성, 최소성 만족하는 후보키 저장
    public static ArrayList<List<String>> candidateKeys = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        int tuple = relation.length;
        int column = relation[0].length;
        boolean[] visited = new boolean[column];

        // 조합을 이용하여 모든 후보키 조합 추출
        for(int i=1; i<= column; i++) {
            comb(visited, 0, i);
        }

        // 후보키 유일성 판별
        for(int i=0; i< list.size(); i++) {
            HashSet<String> set = new HashSet<>();  //중복 없이 제공하는 HashSet을 이용해 후보키 조합으로 뽑아진 튜플 저장
            String[] keys = list.get(i).split("");

            for(int j=0; j<relation.length; j++) {
                StringBuilder r = new StringBuilder();

                for(int k=0; k<keys.length; k++) {
                    r.append(relation[j][Integer.parseInt(keys[k])]);
                }
                set.add(r.toString());
            }

            // 전체 튜플의 수와 후보키 조합으로 뽑아진 튜플의 수가 같다면 후보키 유일성 통과
            // 후보키 최소성 판별
            // containsAll 매서드 사용하기 위해 List 사용
            // 기존의 String의 contains 매서드 쓰면 123,13 을 포함하지 않음으로 판별하기 떄문
            if(set.size() == tuple) {
                List<String> cKey = Arrays.asList(list.get(i).split(""));

                boolean flag = true;
                for(int j=0; j< candidateKeys.size(); j++) {
                    if(cKey.containsAll(candidateKeys.get(j))) {    // 후보키 리스트에 부분집합으로 있다면 최소성 만족 X
                        flag = false;
                        break;
                    }
                }

                if(flag) {  // 어떠한 부분집합으로도 없다면 최소성 통과
                    candidateKeys.add(cKey);
                }
            }
        }

        // 유일성과 최소성 판별을 통과한 후보키만을 담고 있는 후보키 리스트의 사이즈가 바로 결과
        return candidateKeys.size();
    }

    private static void comb(boolean[] visited, int start, int r) {
        if(r == 0) {
            StringBuilder num = new StringBuilder();
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) {
                    num.append(i);
                }
            }

            list.add(num.toString());

            return;
        } else {
            for(int i = start; i<visited.length; i++) {
                visited[i] = true;
                comb(visited, i+1, r-1);
                visited[i] = false;
            }
        }
    }

}
