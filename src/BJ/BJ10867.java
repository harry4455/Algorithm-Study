package BJ;/*
    #10867 중복 빼고 정렬하기

    처음엔 배열이나 ArrayList를 활용해서 풀어보려고 했음.
    구글링 중, 중복된 내용을 걸러주는 Treeset을 활용한 내용을 보게 되었고
    이를 활용하여 풀이함.
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BJ10867 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Set<Integer> set = new TreeSet<Integer>();
        while (N-- > 0) {
            set.add(sc.nextInt());
        }

        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
