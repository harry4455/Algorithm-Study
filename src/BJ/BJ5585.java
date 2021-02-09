/*
    #5585 거스름돈
    그리디 쓰면 된다는데
    탐욕 알고리즘이 이런식으로 하면 될라나
 */

package BJ;

import java.util.Scanner;

public class BJ5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1000 - sc.nextInt();
        int[] coinArr = {500, 100, 50, 10, 5, 1};
        int num = 0;
        for(int i=0; i<6; i++) {
            if(n/coinArr[i] > 0){
                num += n/coinArr[i];
                n = n % coinArr[i];
            }
        }
        System.out.println(num);
    }
}
