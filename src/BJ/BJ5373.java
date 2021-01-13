package BJ;

import java.io.*;
import java.util.*;

public class BJ5373 {
    static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
    static InputReader in;
    static PrintWriter out;

    int T, n;
    char[][][] cube;

    void init(char[] colors){
        int num = colors.length;
        cube = new char[num][][];

        for(int i=0; i<num; ++i) {
            cube[i] = new char[3][3];
            for(int j=0; j<3; ++j) {
                for(int k=0; k<3; ++k) {
                    cube[i][j][k] = colors[i];
                }
            }
        }
    }

    void alter(int f, int u, int l, int d, int r, boolean clk) {
        char[][] tmp = new char[3][3];
        char[] tmp2 = new char[3];


        if(clk) {   // '+' 시계 방향일 때
            for(int i=0; i<3; ++i)
                for(int j=0; j<3; ++j)
                    tmp[i][j] = cube[f][2-j][i];
            for(int i=0; i<3; ++i)
                tmp2[i] = cube[u][i][0];
            for(int i=0; i<3; ++i)
                cube[u][i][0] = cube[l][0][2-i];
            for(int i=0; i<3; ++i)
                cube[l][0][2-i] = cube[d][2][i];
            for(int i=0; i<3; ++i)
                cube[d][2][i] = cube[r][2-i][2];
            for(int i=0; i<3; ++i)
                cube[r][2-i][2] = tmp2[i];
        } else {    // 시계 반대방향일 때
            for(int i=0; i<3; ++i)
                for(int j=0; j<3; ++j)
                    tmp[i][j] = cube[f][j][2-i];
            for(int i=0; i<3; ++i)
                tmp2[i] = cube[u][i][0];
            for(int i=0; i<3; ++i)
                cube[u][i][0] = cube[r][2-i][2];
            for(int i=0; i<3; ++i)
                cube[r][2-i][2] = cube[d][2][i];
            for(int i=0; i<3; ++i)
                cube[d][2][i] = cube[l][0][2-i];
            for(int i=0; i<3; ++i)
                cube[l][0][2-i] = tmp2[i];

        }
        cube[f] = tmp;
    }

    void rotate(String str){
        boolean clk = str.charAt(1) == '+';

        switch(str.charAt(0)){
            case 'U' : alter(U, L, F, R, B, clk); break;
            case 'D' : alter(D, B, R, F, L, clk); break;
            case 'F' : alter(F, U, L, D, R, clk); break;
            case 'B' : alter(B, R, D, L, U, clk); break;
            case 'L' : alter(L, F, U, B, D, clk); break;
            case 'R' : alter(R, D, B, U, F, clk); break;
        }
    }

    void printU(){
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j)
                out.print(cube[0][j][2-i]);
            out.println();
        }

    }



    void solve(){
        T = in.nextInt();
        while(T-- > 0) {
            init(new char[]{'w','y','r','o','g','b'});
            n = in.nextInt();
            while(n-- > 0) {
                rotate(in.nextStr());
            }
            printU();
        }
    }

    public static void main(String []args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        new BJ5373().solve();
        out.close();

    }

    static class InputReader{
        BufferedReader br;
        StringTokenizer stk;

        public InputReader(InputStream is){
            br = new BufferedReader(new InputStreamReader(is));
            stk = null;
        }

        public String nextStr(){
            while(stk == null || !stk.hasMoreTokens()){
                try {
                    stk = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return stk.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(nextStr());
        }
    }
}
