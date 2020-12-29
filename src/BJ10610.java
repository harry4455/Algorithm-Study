import java.util.Scanner;

public class BJ10610 {
    public static final int MAX = 100000;

    public static String str;
    public static int[] numCntArr;
    public static long strLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        strLen = str.length();
        numCntArr = new int[10];
        long total = 0;
        for(int i=0; i<strLen; i++) {
            int tNum = Integer.parseInt(str.substring(i, i+1));
            numCntArr[tNum] += 1;
            total += tNum;
        }

        // 끝자리수가 0이어야 30의 배수, 따라서 0이 반드시 포함 되어있어야함
        // 각 자리수의 합이 3의 배수여야 함
        if(!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            while(numCntArr[i] > 0 ){
                sb.append(i);
                numCntArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
