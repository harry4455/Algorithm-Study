package BJ;

import java.util.*;
import java.io.*;

public class BJ2947 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        int[] arrNext = new int[5];

        for(int i=0; i<5; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<5; i++) {
            arrNext[i] = arr[i];
        }

        Arrays.sort(arrNext);

        while(true) {
            for(int i=1; i<5; i++)  {
                if(arr[i-1] > arr[i]){
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    for(int value: arr){
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }

            if(Arrays.equals(arr, arrNext)) break;
        }
    }
}