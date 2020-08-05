// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-Java
import java.util.Arrays;

public class Solution702 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        System.out.println(solution(distance, rocks, n));
    }
    public static int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }

    static int binarySearch(int distance, int[] rocks, int n) {
        long answer = 0;
        long left = 1;
        long right = distance;
        long mid = 0; //  구하고자 하는 최솟값

        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for(int i=0; i<rocks.length; i++) {
                if(rocks[i] - prev < mid) { // mid 보다 작은 값이 존재한다는 뜻으로 해당 돌을 제거
                    cnt++;
                } else { // mid보다 크거나 같은 값이 존재함으로 prev를 현재 돌로 초기화
                    prev = rocks[i];
                }
            }

            // 마지막 돌과 도착점 사이의 거리 확인
            if(distance - prev < mid) cnt++;

            if(cnt <= n) {
                // 주어진 n보다 작거나 같은 만큼 돌을 제거해서 최솟값을 만든다.
                answer = mid > answer ? mid : answer;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) answer;
    }
}
