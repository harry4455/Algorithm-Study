import java.io.*;

public class BJ4796 {

    static int L, P, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;

        while(true){
            int result = 0;
            String[] nums = br.readLine().split(" ");
            L = Integer.parseInt(nums[0]);
            P = Integer.parseInt(nums[1]);
            V = Integer.parseInt(nums[2]);

            if(L == 0) break;

            int q = V/P;
            int r = V%P;

            if(r < L) {
                result += ((q*L) + r);
                System.out.println("Case " + cnt + ": " + result);
            } else {
                result += ((q+1)*L);
                System.out.println("Case " + cnt + ": " + result);
            }

            cnt++;
        }
    }
}