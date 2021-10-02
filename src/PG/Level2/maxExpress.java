/*
 *  # 수식 최대화
 *  2020 카카오 인턴십 문제
 *
 *
 */
package PG.Level2;

import java.util.ArrayList;

public class maxExpress {
    static ArrayList<String> operandList = new ArrayList<>();   // 연산자를 담는 리스트
    static ArrayList<Long> numList= new ArrayList<>();          // 숫자를 담는 리스트

    static String[] operands = {"+", "-", "*"};
    static String[] output = new String[3];                     // 순열 결과 담을 배열
    static boolean[] visited = new boolean[3];

    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        String n = "";

        for(int i=0; i<expression.length(); i++) {
            char exp = expression.charAt(i);
            if(exp == '+' || exp == '*' || exp == '-') {
                operandList.add(exp + "");
                numList.add(Long.parseLong(n));
                n = "";
            } else {
                n += exp;
            }
        }

        // 마지막 숫자 삽입
        numList.add(Long.parseLong(n));

        // 순열 만들기
        per(0, operands.length);

        return answer;
    }

    // 순열
    private static void per(int depth, int round) {
        if(depth == round) {
            solve();    // 연산실행
            return;
        }

        for(int i=0; i<operands.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = operands[i];
                per(depth+1, round);
                visited[i] = false;
            }
        }
    }

    private static void solve() {
        //연산자 우선순위에 따른 값을 얻기 위해 리스트 복사
        ArrayList<String> oper = new ArrayList<String>(operandList);
        ArrayList<Long> num = new ArrayList<Long>(numList);

        for(int i=0; i<output.length; i++) {
            String currOper = output[i];        // 현재 우선순위 연산자

            for(int j=0; j<oper.size(); j++) {
                if(oper.get(j).equals(currOper)) {  // 현재 우선수위에 맞는 연산자일 경우
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    long res = cal(n1, n2, currOper);   // 연산진행

                    num.remove(j+1);    // 숫자 삭제
                    num.remove(j);
                    oper.remove(j);          // 연산 결과 삭제

                    num.add(j, res);         // 연산결과 넣기
                    j--;                     // 삭제했으니 인덱스 하나 줄여주기
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    private static long cal(long n1, long n2, String currOper) {
        long res = 0;
        switch (currOper) {
            case "+" :
                res = n1 + n2;
                break;
            case "-" :
                res = n1 - n2;
                break;
            case "*" :
                res = n1 * n2;
                break;
        }

        return res;
    }
}
