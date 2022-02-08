/*
 * # k진수에서 소수 개수 구하기
 *
 * 소수 구하는 isPrime에서 범위 산정 잘못해서 계속 에러 발생했었음
 * 루트 n까지 포함해서 범위 산정해야됨
 */

package PG.Level2;

public class primeNumKth {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        System.out.println(solution(n,k));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String nums = "";

        while(n > 0) {
            nums = (n % k) + nums;
            n /= k;
        }

        String[] nums2 = nums.split("0");

        for(String ns : nums2) {
            if(ns.equals("")) continue;
            if(isPrime(Long.parseLong(ns))) answer++;
        }
        return answer;
    }

    private static boolean isPrime(long ns) {
        if(ns < 2) return false;
        for(int i=2; i <= Math.sqrt(ns); i++){
            if(ns % i == 0) return false;
        }
        return true;
    }
}
