package BJ;

import java.io.*;
import java.util.*;

public class BJ2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            al.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];
        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(stk.nextToken());
            int before = Integer.parseInt(stk.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(stk.nextToken());
                al.get(before).add(singer);
                indegree[singer]++;

                before = singer;
            }
        }

        String ans = topologicalSort(al, indegree, N);

        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }

    // 위상정렬
    private static String topologicalSort(ArrayList<ArrayList<Integer>> al, int[] indegree, int N) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for(int next : al.get(now)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        /**
         * result에서 size가 N이 아니라는 것은
         * 그래프에서 사이클이 발생했기 때문
         * 다시 말해 N명의 전체 순번을 돌기전에 내부 사이클이 생겨
         * 전체를 돌지 못한다.
         */
        if(result.size() != N) {
            return "0\n";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++) {
            sb.append(result.get(i) + "\n");
        }

        return sb.toString();
    }
}
