import java.util.*;
import java.io.*;

public class BJ1037{
    public static void main(String []args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0] * arr[N-1]);

    }
}