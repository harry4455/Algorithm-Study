/*
 * # 추석 트래픽
 *
 * 카카오 2018 공채 기출
 */

package PG.etc.kakao;

import java.util.*;
import java.text.*;

public class chuseokTraffic {
    public static void main(String[] args) throws Exception {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] counts = new int[lines.length];
        int max = 0;

        for(int i=0; i<lines.length; i++) {
            // 이전 로그의 완료 시점
            String[] prev = lines[i].split(" ");
            Date preEndDate = format.parse(prev[1]);
            long preEnd = preEndDate.getTime();

            // 해당 로그보다 늦게 종료되는 로그 체크
            for(int j = i; j < lines.length; j++) {
                // 다음 로그의 시작 시점
                String[] next = lines[j].split(" ");
                Date nextEndDate = format.parse(next[1]);
                long nextEnd = nextEndDate.getTime();
                double sec = Double.parseDouble(next[2].substring(0, next[2].length() - 1));  // 처리 시간

                // 다음로그의 종료 시점 - 처리 초 + 1
                long nextStart = (long) (nextEndDate.getTime() - sec * 1000 + 1);

                // 이전 로그의 종료 시점 + 1초 범위 안에 시작되면 결과에 1을 더해줌
                if(preEnd + 1000 > nextStart) {
                    counts[i]++;
                    max = Math.max(max, counts[i]);
                }
            }
        }

        return max;
    }
}
