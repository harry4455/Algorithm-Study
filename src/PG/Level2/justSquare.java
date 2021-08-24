/*
 * # 멀쩡한 사각형
 *
 * 최대공약수, 대각선 내려갈때 수 잘 따지기
 *
 * 대각선으로 거쳐 내려갈때 가로길이 + 세로길이 - 1
 * 결국 모든 가로와 세로의 길이를 거쳐 내려가기 떄문 + 하나의 사각형은 무조건 겹침
 *
 */
package PG.Level2;

public class justSquare {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        solution(w,h);
    }

    public static long solution(int w, int h) {
        long answer = 1;
        long gcdNum = (long)GCD(w,h);
        long nW = (long)w / gcdNum; // 가로
        long nH = (long)h / gcdNum; // 세로
        answer = ((long)w * (long)h) - ((nW + nH - 1) * gcdNum);
        return answer;
    }

    private static int GCD(int w, int h) {
        if(w % h == 0) {
            return h;
        }
        return GCD(h, w%h);
    }
}
