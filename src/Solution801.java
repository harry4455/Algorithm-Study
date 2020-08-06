import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution801 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int len = commands.length;
        int cnt=0;

        do {
            int[] arrcpy = new int[array.length];

            for(int i=0; i < array.length; i++) {
                arrcpy[i] = array[i];
            }

            // System.out.println("arrcpy : " + Arrays.toString(arrcpy));

            int start = commands[cnt][0] - 1;
            int end = commands[cnt][1] - 1;
            int point = commands[cnt][2] - 1;
            // System.out.println("start : " + start);
            // System.out.println("end : " + end);

            int[] slice = new int[end-start+1];
            // System.out.println("slice : " + Arrays.toString(slice));
            for(int j=0; j < slice.length; j++) {
                slice[j] = arrcpy[start + j];
            }

            Arrays.sort(slice);
            // System.out.println("slice : " + Arrays.toString(slice));

            answer[cnt] = slice[point];
            cnt++;

            // System.out.println("cnt : " + cnt);
        } while(cnt < len);
        return answer;
    }
}
