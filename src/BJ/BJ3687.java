/*
    #3687 성냥개비

    처음에는 숫자별로 들어가는 성냥개비 갯수를 static배열로 삼아 매 입력건수마다 연산하려고 했었다.

    한계점을 느끼고, dp라는 점에 주안하여 최대,최소값을 찾도록 다시 방안을 모색했으며
    최댓값에서 홀짝마다 규칙적으로 출력되는 숫자를 찾을 수 있었다.
    그러나 최솟값의 경우 좀 헷갈려서 고민하다가 구글링을 진행.

    모든 합의 조합으로 숫자배치를 진행하며 최솟값을 찾으면 dp 배열에 넣어준다.

    마지막으로 input값으로 dp에서 최소, 최대에 해당하는 값을 출력해준다.

 */

package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ3687 {
    //static int[] nums = {6,2,5,5,4,5,6,3,7,6};  // 각 숫자마다 들어가는 성냥개비 수 (0부터 9)

    static int N;
    static int M;
    static long[] minDP;
    static String[] maxDP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        minDP = new long[101];
        maxDP = new String[101];

        Arrays.fill(minDP, Long.MAX_VALUE);
        minDP[2] = 1;
        minDP[3] = 7;
        minDP[4] = 4;
        minDP[5] = 2;
        minDP[6] = 6;
        minDP[7] = 8;
        minDP[8] = 10;

        String[] add = {"1","7","4","2","0","8"};

        for(int i=9; i<=100; i++) {
            for(int j=2; j<=7; j++) {
                String line = minDP[i-j] + add[j-2];
                minDP[i] = Math.min(Long.parseLong(line), minDP[i]);
            }
        }

        String[] add2 = {"0","0","1","7","4","2","6","8"};
        maxDP[2] = "1";
        for(int i=3; i<=100; i++) {
            String line = "";
            if(i%2 == 0) {  // 짝수
                for(int k=0; k<i/2; k++) {
                    line += "1";
                }
            } else {
                int val = i/2 - 1;
                for(int k=0; k<val; k++) {
                    line += "1";
                }
                line = add2[i-(val*2)] + "" + line;
            }
            maxDP[i] = line;
        }

        for(int i=0; i<N; i++) {
            M = sc.nextInt();
            System.out.println(minDP[M] + " " + maxDP[M]);
        }


    }
}
