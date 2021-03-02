/*
    #12100 2048(Easy)



 */

package BJ;

import java.util.Scanner;
import java.util.Stack;

public class BJ12100 {
    private static int n;
    private static int max;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        max = 0;
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] > max) max = board[i][j];
            }
        }

        solution(board, 0);
        System.out.println(max);
    }

    private static void solution(int[][] board, int count) {
        if(count == 5) return;
        solution(up(board), count+1);
        solution(down(board), count+1);
        solution(right(board), count+1);
        solution(left(board), count+1);
    }

    private static int[][] left(int[][] board) {
        int[][] result = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] != 0) {
                    if(stack.size() == 0) {
                        stack.add(board[i][j]);
                    } else {
                        if(stack.peek() == board[i][j] && flag) {
                            stack.add(stack.pop() + board[i][j]);
                            flag = false;
                            if(stack.peek() > max) max = stack.peek();
                            continue;
                        } else {
                            stack.add(board[i][j]);
                        }
                    }
                    flag = true;
                }
            }
            while(!stack.isEmpty()){
                int j = stack.size() - 1;
                result[i][j] = stack.pop();
            }
            stack.clear();
        }
        return result;
    }

    private static int[][] right(int[][] board) {
        int[][] result = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=0; j--){
                if(board[i][j] != 0) {
                    if(stack.size() == 0){
                        stack.add(board[i][j]);
                    } else {
                        if(stack.peek() == board[i][j] && flag) {
                            stack.add(stack.pop() + board[i][j]);
                            flag = false;
                            if(stack.peek() > max) max = stack.peek();
                            continue;
                        } else {
                            stack.add(board[i][j]);
                        }
                    }
                    flag = true;
                }
            }
            while(!stack.isEmpty()) {
                int j = n - stack.size();
                result[i][j] = stack.pop();
            }
            stack.clear();
        }
        return result;
    }

    private static int[][] down(int[][] board) {
        int[][] result = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        for(int j=0; j<n; j++) {
            for(int i=n-1; i >= 0; i--) {
                if(board[i][j] != 0) {
                    if(stack.size() == 0) {
                        stack.add(board[i][j]);
                    } else {
                        if(stack.peek() == board[i][j] && flag) {
                            stack.add(stack.pop() + board[i][j]);
                            flag = false;
                            if(stack.peek() > max) max = stack.peek();
                            continue;
                        } else {
                            stack.add(board[i][j]);
                        }
                    }
                    flag = true;
                }
            }
            while(!stack.isEmpty()) {
                int i = n - stack.size();
                result[i][j] = stack.pop();
            }
            stack.clear();
        }
        return result;
    }

    private static int[][] up(int[][] board) {
        int[][] result = new int[n][n];
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        for(int j=0; j<n; j++) {    // 가로로 이동
            for(int i=0; i<n; i++) {    // 세로로 이동
                if(board[i][j] != 0) {
                    if(stack.size() == 0) {
                        stack.add(board[i][j]);
                    } else {
                        if(stack.peek() == board[i][j] && flag) { // 블록 합치기
                            stack.add(stack.pop() + board[i][j]);
                            flag = false;
                            if(stack.peek() > max) max = stack.peek();
                            continue;
                        } else {
                            stack.add(board[i][j]);
                        }
                    }
                    flag = true;
                }
            }
            while(!stack.isEmpty()) {
                int i = stack.size() - 1;
                result[i][j] = stack.pop();
            }
            stack.clear();
        }
        return result;
    }
}
