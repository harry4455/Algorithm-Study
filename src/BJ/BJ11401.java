/*
    #11401 이항계수 3

    일단 이항계수라 함은 수학적으로 Combination 연산을 말하는 거임. (nCr 이런연산)
    보통 이항계수 연산은 팩토리얼로 나아감
    nCk = n! / ( k! (n-k)! )

    하지만 수가 커지면 시간초과가 발생하기 때문에 다른 방법을 활용해야함

     nCk = n! / ( k! (n-k)! )   % p
         = n! * ( k! (n-k)! )^(-1)   % p
         = a * b^(-1)   % p             ( a = n!, b = k!*(n-k)! )
         = a * b^(-1) * 1   % p        ( b^(p-1) % p = 1 )
         = ( ( a % p ) ( b^( p-2 ) % p ) )   % p

    이러한 분할정복식 방식과 페르마의 소정리를 활용하면 풀이가 가능함.
 */

package BJ;

import java.util.Scanner;

public class BJ11401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        long p = 1000000007;

        long[] f = new long[N+1];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<=N; i++) {
            f[i] = (f[i-1] * i) % p;
        }
        long a = f[N];
        long b = (f[K] * f[N-K]) % p;

        long e = p-2;
        long b_pow = 1;
        while(e > 0) {
            if(e % 2 == 1) {
                b_pow = (b_pow * b) % p;
            }
            b = (b * b) % p;
            e /= 2;
        }
        System.out.println(((a % p) * (b_pow % p)) % p);
    }
}
