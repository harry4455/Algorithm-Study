/*
 * # 소수 찾기
 *
 * 각 숫자를 조합하는 방법에 있어서 백트래킹(완전탐색)이 사용
 * 나의 경우 최대로 만들어 질 수 있는 자리수의 크기 (10,000,000)를 boolean 배열로 두었지만,
 * HashSet을 이용하여 판별하는 좋은 방법도 있었음
 *
 * 이후에 만들어진 숫자가 소수인지 판별하여 최종 결과 도출.
 */
package PG.Level2;

public class FindingPrimeNumber {
    static boolean[] comb = new boolean[10000000];
    static boolean[] taken = new boolean[7];
    static String num;

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        num = numbers;
        rec("", 0);
        for(int i=2; i<10000000; i++) {
            if(comb[i] && isPrime(i)) answer++;
        }

        return answer;
    }

    // 소수 확인하기
    private static boolean isPrime(int num) {
        for(int i=2; i<=num/2; ++i) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    // 모든 조합을 확인하는 재귀함수
    private static void rec(String str, int idx) {
        //1. 재귀 함수 탈출 조건
        if(idx == num.length()+1) {
            return;
        }

        // 2. 현재까지 조합된 숫자를 comb 배열에 표시
        if(str != ""){
            int num = Integer.parseInt(str);
            comb[num] = true;
        }

        // 3. 0~n-1 까지의 숫자카드 중 아직 사용되지 않은 카드를 하나씩 사용하여 붙여서 다음 재귀로 넘기기
        for(int i=0; i<num.length(); i++) {
            if(!taken[i]) {
                taken[i] = true;
                rec(str+num.charAt(i), idx+1);
                taken[i] = false;
            }
        }
    }
}