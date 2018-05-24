package problems.p020;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 	Open brackets must be closed by the same type of brackets.
 * 	Open brackets must be closed in the correct order.
 * 
 * Note that an empty string is also considered valid.
 * 
 * @author yuryk
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char bracket = stack.pop();
                if (
                    (bracket == '(' && c != ')')
                    || (bracket == '{' && c != '}')
                    || (bracket == '[' && c != ']')
                )
                {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
