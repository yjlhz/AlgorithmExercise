package LeetCodeExercise;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] strings = {"4","13","5","/","+"};
        System.out.println(evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for(int i = 0;i < len;i++){
            if(tokens[i].charAt(0)=='+'){
                int x = stack.pop();
                int y = stack.pop();
                int z = x+y;
                stack.push(z);
            }else if(tokens[i].charAt(0)=='-'){
                int x = stack.pop();
                int y = stack.pop();
                int z = y-x;
                stack.push(z);
            }else if(tokens[i].charAt(0)=='*'){
                int x = stack.pop();
                int y = stack.pop();
                int z = x*y;
                stack.push(z);
            }else if(tokens[i].charAt(0)=='/'){
                int x = stack.pop();
                int y = stack.pop();
                int z = y/x;
                stack.push(z);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
