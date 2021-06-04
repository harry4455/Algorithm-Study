package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1068 {
    static int N, deleteNode;
    static int ans=0;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N];
        tree = new ArrayList[N];

        int root = 0;
        for(int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
            visited[i] = false;
        }
        for(int i=0; i<N; i++) {
            int parent = sc.nextInt();
            if(parent != -1) {
                tree[i].add(parent);
                tree[parent].add(i);
            } else {
                root = i;
            }
        }

        deleteNode = sc.nextInt();

        if(deleteNode == root) System.out.println(ans);
        else {
            dfs(root);
            System.out.println(ans);
        }

    }

    static void dfs(int node) {
        visited[node] = true;
        int childNum = 0;
        for(int i=0; i<tree[node].size(); i++) {
            int adjNode = tree[node].get(i);
            if(!visited[adjNode] && adjNode != deleteNode) {
                childNum++;
                dfs(adjNode);
            }
        }
        if(childNum == 0) {
            ans++;
        }
    }
}
