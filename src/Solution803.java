import java.util.Arrays;

// 배열을 정렬하고 중간 지점부터 확인하면 된다고 처음에 생각함.
// 참고 결과 정렬된 배열을 앞에서부터 순차적으로 확인해 나가는 것이 더 효율적임을 알게 됨.

public class Solution803 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        //System.out.println(Arrays.toString(citations));

        for(int i=0; i< citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
