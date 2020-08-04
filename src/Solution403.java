import java.util.Stack;

public class Solution403 {

    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

        System.out.println(solution(baseball));
    }

    public static void makeNums(Stack<String> stack) {
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++){
                for(int k=1; k<=9; k++) {
                    if(i!=j && j!=k && k!=i) {
                        stack.push(String.valueOf(100*i+10*j+k));
                    }
                }
            }
        }
    }

    public static boolean check(String num, int[][] baseball) {
        String base = "";
        int strike=0, ball=0;
        for(int i=0; i<baseball.length; i++) {
            base = String.valueOf(baseball[i][0]);
            for(int j=0; j<3; j++) {
                if(num.charAt(j) == base.charAt(j)) {
                    strike++;
                }
                if(base.contains(String.valueOf(num.charAt(j)))){
                    ball++;
                }
            }
            ball = ball - strike; // 볼과 스트라이크는 겹치지 않음
            if(strike != baseball[i][1] || ball != baseball[i][2]) {
                return false;
            }
            strike = 0;
            ball = 0;
        }
        return true;
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String num;
        boolean flag = false;
        makeNums(stack);
        while(!stack.isEmpty()) {
            num = stack.pop();
            if(check(num, baseball)) {
                answer++;
            }
        }

        return answer;
    }

}
