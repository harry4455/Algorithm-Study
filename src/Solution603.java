// https://mapled.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A43%EB%8B%A8%EA%B3%84%EC%9E%90%EB%B0%94-%EB%8B%A8%EC%96%B4-%EB%B3%80%ED%99%98

public class Solution603 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin, target, words);

    }

    public static int solution(String begin, String target, String[] words) {
        int answer = words.length + 1; // 최대일 경우
        boolean[] visited = new boolean[words.length];

        answer = dfs(begin, target, words, visited, 0, words.length + 1, words.length);

        return answer == words.length + 1 ? 0 : answer;
    }

    static int dfs(String begin, String target, String[] words, boolean[] visited, int n, int min, int max) {

        for (int i = 0; i < max; i++) {
            if (!visited[i] && compareStrings(begin, words[i])) {
                if (words[i].equals(target)) {
                    return Math.min(min, n + 1);
                }
                visited[i] = true;
                int num = dfs(words[i], target, words, visited, n + 1, min, max);
                if (num < min) min = num;
                visited[i] = true;
            }
        }
        return min;
    }

    static boolean compareStrings(String begin, String word) {

        int tmp = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                tmp++;
                if (tmp > 1) return false;
            }
        }

        return true;
    }
}
