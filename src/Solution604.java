// https://geehye.github.io/programmers-dfs-bfs-04/#

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution604 {
    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    static String route = "";

    public static void main(String[] args) {
        //String[][] tickets = {{"ICN","JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {

        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[tickets.length];
            String dep = tickets[i][0], arr = tickets[i][1];

            if (dep.equals("ICN")) {
                route = dep + ",";
                visited[i] = true;
                dfs(tickets, arr, 1);
            }
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println("sorted list " + list);

        String[] answer = list.get(0).split(",");

        return answer;
    }

    static void dfs(String[][] tickets, String arr, int cnt) {
        route += arr + ",";

        if (cnt == tickets.length) {
            list.add(route);
            System.out.println(list);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String d = tickets[i][0], a = tickets[i][1];
            if (d.equals(arr) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, a, cnt + 1);
                visited[i] = false;
                System.out.println("original route " + route);
                route = route.substring(0, route.length() - 4);
                System.out.println("the route " + route);
            }
        }
    }
}
