/*
 * #부족한 금액 계산하기
 * 위클리 챌린지
 *
 * 믿거나~말거나~ 2021 네이버 상반기 채용 1번 문제랑 유사하대요~
 *
 * 어떤 우수 풀이중에, return 값에 등차수열 합과 0으로 최댓값 비교해서 결과 산출하는거 한줄 풀이 해놓았음.
 */
package PG.etc;

public class CountLackMoney {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        solution(price, money, count);
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;

        int lastPrice = price * count;
        long totalPrice = (long) (price + lastPrice) * count / 2;
        if(money > totalPrice) {
            return 0;
        } else {
            answer = totalPrice - money;
        }

        return answer;
    }
}
