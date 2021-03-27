/*
    #17281 야구문제

    순열과 brute force를 활용했던 문제

    타자를 뽑는데 순열을 활용한다.

    5가지 경우에 대해서는 switch-case 문으로 분류하여 연산을 진행

 */
package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ17281 {
    static int N;
    static int[][] players; // N번째 이닝에서 타자의 상태
    static boolean[] select;
    static int[] lineup;    // 타순
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());

        players = new int[N+1][10];
        for(int i=1; i<=N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                players[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        select = new boolean[10];
        lineup = new int[10];

        select[4] = true; // 1번 선수를 4번 타자로 고정
        lineup[4] = 1;

        ans = 0;
        perm(2);

        bw.write(ans + "\n");
        bw.close();
        br.close();


    }

    // 순열
    private static void perm(int num) {
        if(num == 10) {
            playBaseBall();
            return;
        }

        for(int i=1; i<=9; i++) {
            if(select[i]) {
                continue;
            }
            select[i] = true;
            lineup[i] = num;
            perm(num+1);
            select[i] = false;
        }
    }

    private static void playBaseBall() {
        int score = 0;
        int startPlayer = 1;    // 이닝에서 처음 시작하는 타자
        boolean[] base; // 1,2,3루와 홈

        for(int i=1; i<=N; i++) {
            int outCnt = 0;
            base = new boolean[4]; // base 초기화

            outer: while(true) {
                for(int j=startPlayer; j <= 9; j++) {
                    int hitter = players[i][lineup[j]]; //j번째 타자의 행동

                    switch (hitter) {
                        case 0: // 아웃되었을 때
                            outCnt++;
                            break;
                        case 1: // 1루타
                            for(int k=3; k>=1; k--) {
                                if(base[k]) {
                                    if(k==3){   //3루타에 있는 선수는 홈으로 들어온다
                                        score++;
                                        base[k] = false;    //3루 비우기
                                        continue;
                                    }
                                    // 1,2루의 경우 자리를 비우고 하나씩 전진
                                    base[k] = false;
                                    base[k+1] = true;
                                }
                            }
                            base[1] = true; // 홈에서 1루로 전진
                            break;
                        case 2: // 2루타
                            for(int k=3; k>=1; k--) {
                                if(base[k]) {
                                    if(k==3 || k==2) {  // 3루나 2루에 있으면 홈으로 들어옴
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }

                                    base[k] = false;
                                    base[k+2] = true;
                                }
                            }
                            base[2] = true; // 홈에서 2루로 전진
                            break;
                        case 3: // 3루타
                            for(int k=3; k>=1; k--) {
                                if(base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            base[3] = true; // 홈에서 3루로 전진
                            break;
                        case 4:
                            for(int k=1; k<=3; k++) {
                                if(base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;    // 홈에서 다시 홈으로
                            break;
                    }
                    if(outCnt == 3) {
                        startPlayer = j+1;
                        if(startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }
                // 3번의 아웃 없이 한 이닝내에 안타를 모두 친 경우 초기화가 필요함.
                // 그렇지 않으면 무한루프에 빠지게 됨
                startPlayer = 1;
            }
        }
        ans = Math.max(score, ans);
    }
}
