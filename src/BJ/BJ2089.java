package BJ;/*
 *    나누기 연산은 -2로
 *    나머지 연산시에는 몫을 버리는게 아니라 올림 처리
 */

import java.util.*;

public class BJ2089 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        if(N==0) {
            System.out.println(N);
        }

        while(N!=0) {
            list.add(Math.abs(N%-2));
            N = (int)Math.ceil((double)N/-2);
        }

        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i));
        }
    }
}