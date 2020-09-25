import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int arr[][] = new int[N][2];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());

        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int scores = 0;

        boolean[] time = new boolean[1001];
        for(int i=0; i<N; i++) {
            for(int j=arr[i][0]; j>0; j--) {
                if(!time[j]) {
                    scores += arr[i][1];
                    time[j] = true;
                    break;
                }
            }
        }
        System.out.println(scores);
    }
}
