import java.util.Stack;

class Solution {

    public String solution(String p) {
        // Phase 1
        if (p.isEmpty()) {
            return p;
        }

        // Phase 2
        int idx = 0, count = 0;
        while (idx < p.length()) {
            count += (p.charAt(idx++) == '(') ? 1 : -1;

            if (count == 0) {
                break;
            }
        }

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        // Phase 3
        if (check(u)) {
            return u + solution(v);
        }

        // Phase 4
        return "(" + solution(v) + ")" + flip(u.substring(1, u.length() - 1));
    }

    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }

            stack.push('(');
        }

        return stack.isEmpty();
    }

    private String flip(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                result.append(')');
                continue;
            }
            result.append('(');
        }

        return result.toString();
    }
}