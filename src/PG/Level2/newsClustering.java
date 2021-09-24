/*
 * # 뉴스 클러스터링
 *
 * 2018 카카오 공채 기출
 *
 * ArrayList로 서로의 값 비교하며 교집합, 합집합 구해서 풀이함.
 */

package PG.Level2;

import java.util.ArrayList;
import java.util.Collections;

public class newsClustering {
    public static void main(String[] args) {

        //String str1 = "handshake";
        String str1 = "FRANCE";
        //String str2 = "shake hands";
        String str2 = "french";

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i=0; i<str1.length() - 1 ; ++i) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);

            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                multiSet1.add(first + "" + second);
            }
        }

        for(int i=0; i<str2.length() - 1 ; ++i) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);

            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                multiSet2.add(first + "" + second);
            }
        }

        Collections.sort(multiSet1);
        Collections.sort(multiSet2);

        System.out.println("multiSet1");
        System.out.println(multiSet1);
        System.out.println("multiSet2");
        System.out.println(multiSet2);

        for(String s : multiSet1) {
            // 교집합
            if(multiSet2.remove(s)) {
                intersection.add(s);
            }
            // 합집합
            union.add(s);
        }

        System.out.println("union");
        System.out.println(union);

        for(String s : multiSet2) union.add(s);

        System.out.println("union");
        System.out.println(union);

        double Jaccard = 0;

        if(union.size() == 0) {
            Jaccard = 1;
        } else {
            Jaccard = (double)intersection.size() / (double)union.size();
        }

        return (int) (Jaccard*65536);
    }
}
