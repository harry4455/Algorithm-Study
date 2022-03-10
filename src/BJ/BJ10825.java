package BJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ10825 {

    static class Elem implements Comparable<Elem>{

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            // 국어 점수 내림차순
            if(korean != other.korean) return other.korean - korean;
            // 영어 점수 오름차순
            if(english != other.english) return english - other.english;
            // 수학 점수 내림차순
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    static int N;
    static Elem[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        a = new Elem[N];
        for(int i=0; i<N; i++) {
            a[i] = new Elem();
            a[i].name = sc.next();
            a[i].korean = sc.nextInt();
            a[i].english = sc.nextInt();
            a[i].math = sc.nextInt();
        }

        pro();
    }

    private static void pro() {
        //TODO
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<a.length; i++) {
            sb.append(a[i].name).append('\n');
        }

        System.out.println(sb.toString());
    }


}
