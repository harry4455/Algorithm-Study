// https://cheolhojung.github.io/posts/algorithm/Programmers-ExpressToN.html

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Solution501 {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        solution(N, number);
    }

    public static int solution(int N, int number) {
        int answer = -1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(N);
        map.put(1, set);

        loop:
        for (int i = 2; i < 9; i++) {
            HashSet<Integer> set1 = new LinkedHashSet<>();

            int NNN = Integer.parseInt(Integer.toBinaryString((int) (Math.pow(2, i) - 1))) * N;

            if (NNN == number) {
                return i;
            }

            set1.add(NNN);

            for (int j = 1; j <= i / 2; j++) {
                Iterator<Integer> it1 = map.get(j).iterator();
                Iterator<Integer> it2 = map.get(i - j).iterator();

                while (it1.hasNext()) {
                    int itValue1 = it1.next();
                    while (it2.hasNext()) {
                        int itValue2 = it2.next();
                        for (Operator o : Operator.values()) {
                            int calculate = o.calculate(itValue1, itValue2);
                            if (calculate == number) {
                                answer = i;
                                break loop;
                            }
                            set1.add(calculate);
                        }
                    }
                }
            }
            map.put(i, set1);
        }

        return answer;
    }

    enum Operator {
        PLUS {
            public int calculate(int i, int j) {
                return i + j;
            }
        }, MINUS {
            public int calculate(int i, int j) {
                return i - j;
            }
        }, BACKMINUS {
            public int calculate(int i, int j) {
                return j - i;
            }
        }, MUL {
            public int calculate(int i, int j) {
                return i * j;
            }
        }, DIV {
            public int calculate(int i, int j) {
                if (j == 0) {
                    return 0;
                }
                return i / j;
            }
        }, BACKDIV {
            public int calculate(int i, int j) {
                if (i == 0) {
                    return 0;
                }
                return j / i;
            }
        };

        public abstract int calculate(int i, int j);
    }
}
