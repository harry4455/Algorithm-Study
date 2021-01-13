package PG;// https://eoghks0521.tistory.com/entry/%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%AC%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv-3-Java

public class Solution701 {

    public static void main(String[] args) {

        int n = 6;
        int[] times = {7, 10};

        System.out.println(solution(n, times));

    }

    public static long solution(int n, int[] times) {

        long start = 0;
        long end = (long) times[times.length - 1] * n;
        long mid = 0;
        long answer = Long.MAX_VALUE;

        while (start <= end) {
            long sum = 0;
            mid = (start + end) / 2;
            for (int time : times) {
                //System.out.println("time : " + time);
                sum += mid / time;
                //System.out.println("sum : " + sum);
            }
            if (sum < n) {
                start = mid + 1;
            } else {
                if (answer > mid) {
                    answer = mid;
                }
                end = mid - 1;
            }
        }
        return answer;
    }

}
