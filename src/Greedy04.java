// 최대 최소 몸무게 합이 limit과 비교했을 때 큰가? 를 기준으로 만들어보기


import java.util.Arrays;

public class Greedy04 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people,limit));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int i=0;

        Arrays.sort(people);

        // 몸무게가 무거운 사람 부터 판단
        for(int j= people.length-1; i<=j; j--){
            if(people[j] + people[i] > limit) {
                answer++;
            } else {
                answer++;
                i++;
            }
        }

        return answer;
    }
}
