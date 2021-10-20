package PG.Level2;

import java.util.Stack;

public class BracketRotation {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        String newStr = s;
        for(int i=0; i<s.length(); i++){
            if(chkString(newStr)) answer++;
            newStr = newStr.substring(1, s.length()) + newStr.charAt(0);
        }

        return answer;
    }

    static boolean chkString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            try {
                switch(s.charAt(i)) {
                    case '[' :
                        stack.add('[');
                        break;
                    case ']' :
                        if(stack.peek() != '[') return false;
                        stack.pop();
                        break;
                    case '{' :
                        stack.add('{');
                        break;
                    case '}' :
                        if(stack.peek() != '{') return false;
                        stack.pop();
                        break;
                    case '(' :
                        stack.add('(');
                        break;
                    case ')' :
                        if(stack.peek() != '(') return false;
                        stack.pop();
                        break;
                }
            } catch(Exception e) {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;

    }
}


