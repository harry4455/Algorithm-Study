/*
    #10816 숫자 카드 2
    Hash 중에서 어떻게든 써봐야 하나, 이분 탐색을 써야하나 했으나
    범위가 2천만이나 되고 메모리 사용량이 많기에
    숫자별 인덱스로 만들어서 세어나가는 것으로 풀이함.

    참고로 2천만에 int 배열이면 개당 4bit씩 쳤을 때, 총 80MB 필요로함.

    문제 조건내(256MB)에 해당함.
 */

package BJ;

import java.util.Scanner;

public class BJ10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[20000001];

        for(int i=0; i<N; ++i) {
            ++nums[sc.nextInt() + 10000000];
        }
        int M = sc.nextInt();

        for(int i=0; i<M; ++i) {
            sb.append(nums[sc.nextInt() + 10000000] + " ");
        }
        System.out.println(sb.toString());
    }
}
