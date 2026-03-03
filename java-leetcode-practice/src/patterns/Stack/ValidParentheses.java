package patterns.Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean solution(String s) {
        if (s.length() < 2)
            return false;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String bracket = String.valueOf(s.charAt(i));
            if (bracket.equals("(")) {
                stack.add(")");
            } else if (bracket.equals("{")) {
                stack.add("}");
            } else if (bracket.equals("[")) {
                stack.add("]");
            } else if (stack.size() == 0 || !stack.pop().equals(bracket) ) {
                return false;
            }
        }

        return (stack.size() > 0) ? false : true;
    }
}
