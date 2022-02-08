/*
 * # 땅따먹기
 *
 * dfs로 풀이했다가 land의 길이가 최대 10만이라 타임아웃 발생
 * dp로 풀이
 * land의 열의 길이가 4로 고정되어 있음을 보고 풀이 진행.
 */
package PG.Level2;

public class LandGame {

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i=0; i<4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
