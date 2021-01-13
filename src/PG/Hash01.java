package PG;// 해시 문제 #1

import java.util.Arrays;

public class Hash01 {

    public static void main(String[] args) {

        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};


        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        String temp = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;

        while (i < completion.length) {
            if (!completion[i].equals(participant[i])) {
                temp = participant[i];
                break;
            } else {
                i++;
            }

            if (!temp.equals("")) {
                answer = temp;
            } else {
                answer = participant[participant.length - 1];
            }
        }

        return answer;
    }
}
