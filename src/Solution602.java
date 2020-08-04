public class Solution602 {
    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(n,computers));
    }

    public static int solution(int n, int[][] computers) {
        int networkCnt = 0;

        boolean[] flag = new boolean[n];

        for(int i=0; i<n; i++){
            if(!flag[i]) {
                dfs(computers, i, flag);
                networkCnt++;
            }
        }
        return networkCnt;
    }

    static boolean[] dfs(int[][] computers, int i, boolean[] flag) {
        flag[i] = true;

        for(int j=0; j<computers.length; j++) {
            if( i != j && computers[i][j] == 1 && flag[j] == false) {
                flag = dfs(computers,j,flag);
            }
        }


        return flag;
    }
}
