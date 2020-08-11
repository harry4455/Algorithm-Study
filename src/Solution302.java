// https://jhnyang.tistory.com/125
// Stack 활용

import java.util.Stack;

// 크게 송신탑, 수신탑으로 나누어서 진행
public class Solution302 {

    public static void main(String[] args) {

        int[] heigths = new int[]{6, 9, 5, 7, 4};

        solution(heigths);
    }

    public static int[] solution(int[] heights) {
        //int[] answer = {};

        Stack<Integer> stack = new Stack<Integer>();
        int senderlen = heights.length;
        int[] answer = new int[senderlen];
        for (int i = 0; i < senderlen; i++) {
            stack.push(heights[i]);
        }
        int sender, receiver;

        // 뒤에서부터 진행 - 오른쪽에서 왼쪽으로 진행하기 떄문에
        for (int senderidx = senderlen - 1; senderidx > 0; senderidx--) {
            sender = stack.pop(); // 추출하고 삭제함.

            // receiver stack을 sender 갯수만큼 초기화
            Stack<Integer> stack2 = new Stack<Integer>();
            int receiverlen = senderidx; // 수신탑은 송신탑 하나 전
            for (int i = 0; i < receiverlen; i++) {
                stack2.push(heights[i]);
            }
            for (int receiveridx = receiverlen - 1; receiveridx >= 0; receiveridx--) {
                receiver = stack2.pop();
                if (receiver > sender) {
                    answer[senderidx] = receiveridx + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
