package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        String[] numArr_str = br.readLine().split(" ");

        int[] numArr = new int[numArr_str.length];
        for(int i=0; i<numArr_str.length; i++) {
            numArr[i] = Integer.parseInt(numArr_str[i]);
        }

        // deq(덱)에 입력 원소(N)만큼 삽입
        LinkedList<Integer> deq = new LinkedList<Integer>();
        for(int i=1; i<=N; i++) deq.offer(i);

        int cnt = 0;
        int half = 0;   // 중간점

        for(int i=0; i<numArr.length; i++) {
            if(deq.size() % 2 == 0) half = (deq.size() / 2) - 1;
            else half = deq.size() / 2;

            int idxDeQ = 0; // 뽑아내고자 할 원소 위치 저장 변수
            for(int j=0; j<deq.size(); j++) {
                if(deq.get(j) == numArr[i]){
                    idxDeQ = j;
                    break;
                }
            }

            // 지점이 중간보다 작으므로 왼쪽이동
            if(half - idxDeQ >= 0) {
                for(int j=0; j<idxDeQ; j++) {
                    int first = deq.pollFirst();
                    deq.addLast(first);
                    cnt++;
                }
                deq.poll();
            } else {
                for(int j=0; j<deq.size() - idxDeQ; j++) {
                    int last = deq.pollLast();
                    deq.addFirst(last);
                    cnt++;
                }
                deq.poll();
            }
        }
        System.out.println(cnt);
    }
}
