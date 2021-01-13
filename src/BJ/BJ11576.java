package BJ;

import java.util.*;

public class BJ11576 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        Stack <Integer> st = new Stack<>();

        int m = sc.nextInt();
        int decimal = 0;
        for(int i=m-1; i>=0; i--) {
            int number = sc.nextInt();
            int multi = (int)Math.pow(A, i);
            decimal += (number * multi);
        }

        while(decimal != 0) {
            st.push(decimal%B);
            decimal /= B;
        }

        int stSize = st.size();

        for(int i=0; i<stSize; i++) {
            if(i == stSize - 1) {
                System.out.print(st.pop());
            } else {
                System.out.print(st.pop() + " ");
            }
        }
    }
}