package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ17780 {
    static class Node{
        int n, d;
        Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    static int N, K;
    static int[][] arrColor;
    static int[][] horse;
    static LinkedList<Node>[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arrColor = new int[N][N];
        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arrColor[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        horse = new int[K][2];      // 말의 x,y 위치
        map = new LinkedList[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        int a,b,c;
        for(int i=0; i<K; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken()) - 1;
            b = Integer.parseInt(stk.nextToken()) - 1;
            c = Integer.parseInt(stk.nextToken());

            if(c == 1) c = 0;
            else if(c == 4) c = 1;

            horse[i][0] = a;
            horse[i][1] = b;

            map[a][b].add(new Node(i,c));
        }
        game();
    }

    private static void game() {
        for(int t=1; t <= 1000; t++) {
            for(int k=0; k < K; k++) {
                int x = horse[k][0];
                int y = horse[k][1];
                int d = map[x][y].get(0).d;

                if(map[x][y].get(0).n != k)
                    continue;

                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx<0 || nx>=N || ny <0 || ny>=N || arrColor[nx][ny] == 2) {
                    map[x][y].get(0).d = d = (d+2) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];

                    if(nx<0 || nx>=N || ny<0 || ny>=N || arrColor[nx][ny] == 2) continue;
                    else {
                        if (move(x, y, nx, ny, arrColor[nx][ny])) {
                            System.out.println(t);
                            return;
                        }
                    }
                } else {
                    if(move(x,y,nx,ny,arrColor[nx][ny])) {
                        System.out.println(t);
                        return;
                    }
                }
            }
        }
        System.out.println("-1");
    }

    private static boolean move(int px, int py, int nx, int ny, int color) {
        if(color == 0) {    // white tile
            while(map[px][py].size() > 0) {
                Node temp = map[px][py].removeFirst();
                horse[temp.n][0] = nx;
                horse[temp.n][1] = ny;
                map[nx][ny].add(temp);
            }
        } else {            // red tile
            while(map[px][py].size() > 0) {
                Node temp = map[px][py].removeLast();
                horse[temp.n][0] = nx;
                horse[temp.n][1] = ny;
                map[nx][ny].add(temp);
            }
        }
        if(map[nx][ny].size() >= 4) return true;
        else return false;
    }
}
