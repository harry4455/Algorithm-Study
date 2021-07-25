/**
 * #9081 단어 맞추기
 *
 * 바로 다음에 올 단어를 맞추기 문제
 * 어떻게 문자를 조합할건지가 관건
 *
 * 우선 문자열 뒤에서부터 2개의 포인터를 잡아 하나씩 비교해가며
 * 앞에 있는 문자(idx)가 뒤에 있는 문자(min)보다 작은 경우를 찾아낸다
 *
 * 그 경우 두지점의 문자를 서로 교환.
 *
 * 이후에 idx 이후에 있는 문자들은 오름차순 정렬하면 끝.
 *
 * 처음에 이해가 어려워 abcd를 순서대로 써가며 정렬했더니 이해 완료.
 */

package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String result = next(br.readLine());
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String next(String s) {
        if(s.length() == 1) return s;

        int min = 0;
        int idx = 0;

        // 뒤에서 부터 탐색하면서 오름차순이 깨지는 인덱스를 확인 (idx)
        loop:
        for(idx = s.length() - 2; idx >= 0; idx--) {
            for(min = s.length() - 1; min > idx; min--) {
                if(s.charAt(idx) < s.charAt(min)) {
                    break loop;
                }
            }
        }

        if(idx == -1) {
            return s;
        }

        // min과 idx를 교환
        char[] arr = s.toCharArray();
        char tmp = arr[min];
        arr[min] = arr[idx];
        arr[idx] = tmp;

        // idx에서 부터 끝까지 오름차순 정렬
        Arrays.sort(arr, idx + 1, arr.length);

        // String으로 return
        StringBuilder sb = new StringBuilder();
        for(char a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}
