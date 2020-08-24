// 탐욕법 #3
// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-Java
/*
현재위치에서 가장 가까운 바꿀 자리를 찾는다.

잘 못풀겠어서 참고했고
나올 수 있는 경우를 모두 따져가며 작성함.

2020.08.21 기준 마지막 테스트 케이스에서 오답으로 처리.

 */

public class Solution_greedy03 {
    /*public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }
    public static int solution(String name) {
        int answer = 0;
        int cnt = 0;
        char[] naming = name.toCharArray();
        boolean[] check = new boolean[naming.length];

        for(int i=0; i < naming.length; i++) {
            if(naming[i] != 'A') {
                cnt++;
            } else {
                check[i] = true;
            }
        }

        int idx = 0;
        for(int i=0; i < cnt; ++i) {
            if(check[idx]) {
                int lidx = idx;
                int ridx = idx;
                int left = 0;
                int right = 0;

                while(check[lidx]) {
                    if(lidx == 0) {
                        lidx = naming.length - 1;
                    } else {
                        lidx--;
                    }
                    left++;
                }

                while(check[ridx]) {
                    ridx = (ridx + 1) % naming.length;
                    right++;
                }

                if(left > right) {
                    idx = ridx;
                    answer += right;
                } else {
                    idx = lidx;
                    answer += left;
                }
            }
            check[idx] = true;
            answer += changeAlphabet(idx, naming);
        }
        return answer;
    }

    private static int changeAlphabet(int idx, char[] naming) {
        int up = naming[idx] - 'A';
        int down = 'Z' - naming[idx] + 1;

        if(up > down) {
            return down;
        } else {
            return up;
        }
    }*/

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }
    public static int solution(String name) {
        int answer = 0;

        // 위 아래로만 이동, 최소한으로
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) != 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                answer += (up < down) ? up : down;
            }
        }

        // A가 아닌 모든 문자를 방문할 수 있는 최소 좌우 이동
        // 모든 위치에서 역으로 돌아가는 경우에는 최소를 찾는다.
        int minMove = name.length() - 1;
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }

        return answer + minMove;
    }

}
