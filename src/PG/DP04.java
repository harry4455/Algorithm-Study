package PG;// 동적계획법(Dynamic Programming) #4

public class DP04 {
    public static void main(String[] args) {
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }
    public static int solution(int[] money) {

        int length = money.length;
        int[] dp = new int[length-1];   // 첫 번째 집을 들르는 도둑
        int[] dp2 = new int[length];    // 첫 번째 집을 안들르는 도둑

        dp[0] = money[0];
        dp[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        for(int i=2; i<length-1; i++) {
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        }
        for(int i=2; i<length; i++) {
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }

        return Math.max(dp[length-2], dp2[length-1]);
    }
}
