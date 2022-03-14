/**
 * # 실패율
 * 2019 카카오 블라인드 기출
 */

package PG.etc.kakao;

import java.util.Arrays;

public class FailureRatio {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] check = new int[N];
        double[] rate = new double[N];

        // 1. N까지의 자연수에 대응되는 값의 갯수
        for(int i=0; i<N; i++) {
            for(int j=0; j<stages.length; j++) {
                if(stages[j] == i+1) {
                    check[i]++;
                }
            }
        }

        System.out.println(Arrays.toString(check));

        // 2. 실패율 구하기
        int denominator = stages.length;
        for(int i=0; i<check.length; i++) {
            int numerator = check[i];
            if(denominator == 0) {
                rate[i] = 0;
            } else {
                rate[i] = (double) numerator / denominator;
            }
            denominator -= check[i];
        }

        System.out.println(Arrays.toString(rate));

        // 3. 결과 구하기 (selection sort)
        double max = 0;
        int target = 1;
        for(int i=0; i<rate.length; i++) {
            max = rate[0];
            target = 1;
            for(int j=0; j<rate.length; j++) {
                if(rate[j] > max) {
                    max = rate[j];
                    target = j + 1;
                }
            }
            rate[target - 1] = -1;
            answer[i] = target;

            System.out.println(Arrays.toString(rate));
        }

        return answer;
    }
}
