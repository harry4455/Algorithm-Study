package BJ;/*
    배열 여러개 놓고 풀려고 했으나 효율성도 그렇고 지저분해 보여서
    점수, 순서에 대한 class를 만들고 활용하는 블로그 코드 참고함.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BJ2822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        List<remember> arr = new ArrayList<remember>();
        for(int i=1; i<9; i++) {
            remember rm = new remember();
            rm.score = sc.nextInt();
            rm.number = i;
            arr.add(rm);
            sum += rm.score;
        }

        arr.sort(Comparator.naturalOrder());    // 오름차순으로 정렬
        System.out.println(sum - arr.get(0).score - arr.get(1).score - arr.get(2).score);   // 앞에 작은거 3개는 빼줌

        List arr2 = new ArrayList();

        for(int i=3; i<8; i++) {
            arr2.add(arr.get(i).number);
        }

        arr2.sort(Comparator.naturalOrder());
        for(int i=0; i<5; i++) {
            System.out.print(arr2.get(i) + " ");
        }


    }

    static class remember implements Comparable<remember>{
        int score;
        int number;

        @Override
        public int compareTo(remember o) {
            if(this.score > o.score) {
                return 1;
            }
            return -1;
        }
    }
}
