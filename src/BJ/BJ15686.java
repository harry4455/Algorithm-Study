/*
    #15686 치킨배달

    치킨집 M개를 골라 stack에 넣고 최소 거리 보다 크면 백트래킹하면서 끝까지 계산
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ15686 {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<House> chickens;
    static ArrayList<House> houses;
    static Stack<House> selectChicken;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N+1][N+1];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selectChicken = new Stack<>();

        for(int i=1; i<=N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());

                if(arr[i][j] == 1) {            // 가정집
                    houses.add(new House(i, j));
                } else if (arr[i][j] == 2) {    // 치킨집
                    chickens.add(new House(i, j));
                }
            }
        }

        select(0, 0);

        System.out.println(minDist);
    }

    static void select(int start, int count) {
        if(count == M) {
            calcDist();
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            selectChicken.push(chickens.get(i));
            select(i + 1, count + 1);
            selectChicken.pop();
        }
    }

    static void calcDist() {
        int sum = 0;
        for(House house : houses) {
            int min = Integer.MAX_VALUE;
            for(House chicken : selectChicken) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min, dist);
            }
            sum += min;

            if(sum > minDist) {
                return;
            }
        }
        minDist = Math.min(sum, minDist);
    }

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
