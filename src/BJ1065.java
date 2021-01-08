import java.util.Scanner;

public class BJ1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(cal(sc.nextInt()));
        sc.close();
    }

    private static int cal(int N) {
        int cnt = 0;    // 한수 갯수

        if(N < 100) {
            return N;
        } else {
            cnt = 99;
            if(N == 1000) {
                N = 999;
            }

            for(int i=100; i<=N; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}