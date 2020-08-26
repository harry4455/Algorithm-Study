// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
// 탐욕법 #2
/*
완전 탐색으로 풀기에는 경우의 수가 너무 말이 안된다.
따라서 선택할 수 있는 범위에서 가장 큰 수를 찾아나가는 방식으로 진행하자.

 */
public class Greedy02 {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }
    public static String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int cnt = number.length() - k;

        int left = 0;
        int right = number.length() - cnt;
        int max = -1;
        int idx = 0;

        while(cnt>0) {
            max = -1;
            for(int i = left; i <= right; ++i) {
                int num = number.charAt(i) - '0';
                if(num > max) {
                    idx = i;
                    max = num;
                }
            }
            sb.append(number.charAt(idx));
            left = idx + 1;
            right = number.length() - --cnt;
        }

        return sb.toString();
    }
}
