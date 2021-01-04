import java.util.*;
import java.io.*;

public class BJ2503 {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        int cnt = 0;
        for(int i=100; i<=987; i++) {
            if(i/100 ==0 || (i%100)/10 ==0 || (i%100)%10 == 0)
                continue;
            if(i/100 == (i%100)/10 ||(i%100)/10 == (i%100)%10 || (i%100)%10 == i/100)
                continue;

            boolean flag = false;
            for(int j=0; j<N; j++) {
                int s = 0;
                int b = 0;
                int temp = list.get(j).num;
                int A = temp / 100;
                int B = (temp % 100) / 10;
                int C = (temp % 100) % 10;

                if(i/100 == A) {
                    s++;
                } else if(i/100 == C || i/100 == B) {
                    b++;
                }

                if((i%100)/10 == B) {
                    s++;
                } else if((i%100)/10 == A || (i%100)/10 == C) {
                    b++;
                }

                if((i % 100) % 10 == C) {
                    s++;
                } else if((i % 100) % 10 == A || (i % 100) % 10 == B) {
                    b++;
                }

                if(list.get(j).strike == s && list.get(j).ball == b) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static class Node {
        int num;
        int strike;
        int ball;

        public Node(int num, int strike, int ball) {
            super();
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }

        @Override
        public String toString(){
            return "Node [baseball = " + num + ", strike = " + strike + ", ball = " + ball + "]";
        }
    }


}