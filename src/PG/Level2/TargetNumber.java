/*
 * # 타겟넘버
 *
 *  dfs/bfs 활용 문제
 *
 * dfs 풀이로 해서, 각 경우를 거쳐 목표정답 숫자와 동일하면 값을 높여가는 방식
 * 최종으로 다른 사람 풀이에서 return에서 모든 연산 처리한거 보고 감탄
 *
 * "return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);"
 * 이런식으로 기술함.
 */

package PG.Level2;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 1;

        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        int curr = numbers[0];
        answer += dfs(curr, 1, numbers, target);
        answer += dfs(-curr, 1, numbers, target);

        return answer;
    }

    private static int dfs(int prev, int idx, int[] numbers, int target) {
        if(idx >= numbers.length) {
            if(target == prev) {
                return 1;
            }
            return 0;
        }

        int cur1 = prev + numbers[idx];
        int cur2 = prev - numbers[idx];

        int ans = 0;
        ans += dfs(cur1, idx+1, numbers, target);
        ans += dfs(cur2, idx+1, numbers, target);

        return ans;

    }
}
