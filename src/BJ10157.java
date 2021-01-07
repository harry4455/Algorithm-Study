import java.io.*;

public class BJ10157 {
    // 북 동 남 서
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int C,R,K;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str1 = br.readLine().split(" ");

        C = Integer.parseInt(str1[0]);
        R = Integer.parseInt(str1[1])+1;
        K = Integer.parseInt(br.readLine());

        int d = -1; // 동서남북 방향
        int i = 0;
        int x = 0;
        int y = 1;
        int check = 1;

        while(check > 0) {
            d = (d+1) % 4;

            if(d%2 == 0)    R--;
            else C--;

            check  = (d % 2 == 0) ? R : C;
            for(int j=0; j<check; j++) {
                i++;
                x += dx[d];
                y += dy[d];
                if(i == K) {
                    System.out.println(y + " " + x);
                    return;
                }
            }
        }
        bw.write("0");
        bw.flush();
    }
}