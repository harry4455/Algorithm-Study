import java.util.Scanner;

public class BJ1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] cntArr = new int[10];

        for(int i=0; i<N.length(); i++) {
            int pointer = Character.getNumericValue(N.charAt(i));
            cntArr[pointer]++;
        }

        int max = 0;
        int sixNine = (cntArr[6] + cntArr[9]);

        //6,9가 짝수개일 때
        if(sixNine % 2 == 0) {
            cntArr[6] = sixNine / 2;
            cntArr[9] = sixNine / 2;
        } else {    //6,9가 홀수개일 때
            cntArr[6] = sixNine / 2 + 1;
            cntArr[9] = sixNine / 2 + 1;
        }

        for(int i : cntArr) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
