import java.util.ArrayList;
import java.util.Arrays;

public class Solution401 {

    public static void main(String[] args) {

        int[] answers = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        //int[] answer = {};
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        /*int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == num1[i]) {
                cnt1++;
            } else if(answers[i] == num2[i]) {
                cnt2++;
            } else if(answers[i] == num3[i]) {
                cnt3++;
            }
            System.out.println(cnt1);
            System.out.println(cnt2);
            System.out.println(cnt3);
        }

        Math.max(Math.max(cnt1, cnt2), cnt3);*/

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == num1[i%num1.length]) {
                score[0]++;
            }
            if(answers[i] == num2[i%num2.length]) {
                score[1]++;
            }
            if(answers[i] == num3[i%num3.length]) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(maxScore == score[0]) {
            list.add(1);
        }
        if(maxScore == score[1]) {
            list.add(2);
        }
        if(maxScore == score[2]) {
            list.add(3);
        }

        return list.stream().mapToInt(i-> i).toArray();
    }

}
