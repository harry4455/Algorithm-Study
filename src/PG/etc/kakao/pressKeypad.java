/**
 * # 키패드 누르기
 *
 * 2020 카카오 인턴십 기출
 */
package PG.etc.kakao;

public class pressKeypad {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));

    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int leftPos = 10;
        int rightPos = 12;

        for(int num : numbers) {

            if(num == 0) num = 11;

            if(num % 3 == 1) {
                sb.append("L");
                leftPos = num;
            } else if(num % 3 == 0) {
                sb.append("R");
                rightPos = num;
            } else {
                int left = (Math.abs(leftPos - num) / 3) + (Math.abs(leftPos - num) % 3);
                int right = (Math.abs(rightPos - num) / 3) + (Math.abs(rightPos - num) % 3);

                if(left < right) {
                    leftPos = num;
                    sb.append("L");
                } else if(left > right) {
                    rightPos = num;
                    sb.append("R");
                } else {
                    if(hand.equals("right")) {
                        rightPos = num;
                        sb.append("R");
                    } else {
                        leftPos = num;
                        sb.append("L");
                    }
                }
            }
        }

        answer = sb.toString();


        return answer;
    }
}
