// 조합이 아닌 내림차순을 활용하자!

import java.util.Arrays;
import java.util.Comparator;

public class Solution802 {
    public static void main(String[] args) {
        int[] numbers = {6,10,2};
        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        String answer = "";

        String[] nums = new String[numbers.length];

        for(int i=0; i<nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(nums[0].startsWith("0")) {
            answer += "0";
        } else {
            for(int j=0; j < nums.length; j++) {
                answer += nums[j];
            }
        }

        return answer;
    }
}
