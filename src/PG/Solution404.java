package PG;

public class Solution404 {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        solution(brown, yellow);
    }

    public static int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;

        for (int i = 1; i <= yellow / 2 + 1; i++) {
            width = i;
            height = (yellow % i == 0) ? yellow / i : yellow / i + 1;

            if (width * 2 + height * 2 + 4 == brown) break;
        }

        return new int[]{Math.max(width, height) + 2, Math.min(width, height) + 2};
    }
}
