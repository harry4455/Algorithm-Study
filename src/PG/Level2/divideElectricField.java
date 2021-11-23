/*
 * # 전력망을 둘로 나누기
 *
 * [ DFS 풀이 ]
 * 1. 양방향 간선을 저장하는 인접리스트 자료구조를 초기화 (list)
 * 2. n-1 반복을 돌리면서 간선을 하나씩 뺀 두 개의 트리를 만든다.
 * 3. 인접리스트 자료구조로 노드의 데이터를 저장한다.
 * 4. DFS탐색으로 노드의 갯수를 탐색한다.
 * 5. 두 트리의 갯수 사이를 구하고 최솟값을 갱신한다.
 *
 * [ Union-Find 풀이 ]
 * 1. 각 노드의 부모노드를 저장하는 parents[]를 초기화
 * 2. n-1번 반복을 ㄷ로리면서 간선을 하나씩 뺀 두개의 트리를 만든다.
 * 3. 번호가 작은 노드가 부모노드로 가게끔 union(a,b)를 수행한다.
 * 4. 1번 노드와 연결되어 있는 노드의 갯수를 구한다.
 * 5. 두 트리의 갯수 차이를 구하고 최솟값 갱신한다.
 *
 */

package PG.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class divideElectricField {

    static List<Integer>[] list;
    static int numOfNodes;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;
        int idx = 0;
        list = new ArrayList [n+1];

        while(idx < n-1) {
            for(int i=1; i<n+1; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<wires.length; i++) {
                if(idx == i) continue;
                int a = wires[i][0];
                int b = wires[i][1];

                list[a].add(b);
                list[b].add(a);
            }

            System.out.println("list : " + Arrays.toString(list));

            numOfNodes = 0;
            dfs(1, -1);
            int res = Math.abs(n - 2 * numOfNodes);
            answer = Math.min(res, answer);
            idx++;
        }

        return answer;
    }

    private static void dfs(int idx, int pa) {
        numOfNodes++;

        for(int nxt : list[idx]) {
            if(pa != nxt) {
                dfs(nxt, idx);
            }
        }
    }
}
