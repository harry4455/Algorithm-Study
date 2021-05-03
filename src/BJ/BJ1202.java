package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());  // 보석수
        int K = Integer.parseInt(stk.nextToken());  // 가방수

        Jewels[] j = new Jewels[N];
        int[] bag = new int[K];

        for(int i=0; i<N; i++) {
            stk = new StringTokenizer(br.readLine());
            j[i] = new Jewels(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        for(int i=0; i<K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(j);
        Arrays.sort(bag);

        Queue<Integer> queue = new PriorityQueue<>();
        long ans = 0;
        int idx = 0;

        for(int i=0; i<K; i++) {
            while(idx < N && j[idx].c <= bag[i]) {
                queue.add(-j[idx].v);
                idx++;
            }
            if(!queue.isEmpty()) {
                ans += Math.abs(queue.poll());
            }
        }
        System.out.println(ans);
    }
}

class Jewels implements Comparable<Jewels>{
    int c;
    int v;

    public Jewels(int c, int v) {
        this.c = c;
        this.v = v;
    }

    @Override
    public int compareTo(Jewels o) {
        return this.c - o.c;
    }
}
