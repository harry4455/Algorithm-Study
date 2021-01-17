package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            stk = new StringTokenizer(br.readLine(), " ");

            switch (stk.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(stk.nextToken()));
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (!queue.isEmpty()) {
                        sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peekLast()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}
