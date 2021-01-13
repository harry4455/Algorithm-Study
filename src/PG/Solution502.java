package PG;

public class Solution502 {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(solution(N));
    }

    public static long solution(int N) {
        long answer = 0;

        long a = 1; // 작은 변
        long b = 1; // 긴 변
        Long temp;
        int cnt = 2;

        while (cnt < N) {

            for (int i = 2; i < N; i++) {
                temp = b;
                b += a;
                a = temp;

                cnt++;

            }

        }

        answer = 2 * (a + b) + 2 * b;


        return answer;
    }
}
