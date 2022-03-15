package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ13144 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        long ans = 0;

        HashSet<Integer> visited = new HashSet<>();
        int left = 0;
        int right = 0;

        while(true) {
            if(right == N) {
                if(left == N) break;
                else {
                    ans += (right - left);
                    left++;
                }
            } else if (!visited.contains(arr[right])) {
                visited.add(arr[right]);
                right++;
            } else {
                ans += (right - left);
                visited.remove(arr[left]);
                left++;
            }
        }

        System.out.println(ans);
    }
}
