import java.util.LinkedList;
import java.util.Stack;

class Solution {

    public long solution(String expression) {
        long answer = 0;

        expression = expression.replace("+", " + ");
        expression = expression.replace("-", " - ");
        expression = expression.replace("*", " * ");

        String[] prioritizedOps = {"+-*", "+*-", "-+*", "-*+", "*-+", "*+-"};

        for (String ops : prioritizedOps) {
            Stack<String> stack = new Stack<>();

            String[] tokens = expression.split(" ");

            for (String op : ops.split("")) {
                int index = 0;

                while (index < tokens.length) {
                    String token = tokens[index];

                    if (token.equals(op)) {
                        String num1 = stack.pop();
                        String num2 = tokens[index + 1];
                        stack.push(String.valueOf(calc(num1, op, num2)));
                        index += 2;
                        continue;
                    }

                    stack.push(tokens[index++]);
                }

                LinkedList<String> temp = new LinkedList<>();
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
                tokens = temp.toArray(new String[0]);
            }

            answer = Math.max(Math.abs(Long.parseLong(tokens[0])), answer);
        }

        return answer;
    }

    private long calc(String num1, String op, String num2) {
        if (op.equals("*")) {
            return Long.parseLong(num1) * Long.parseLong(num2);
        }

        if (op.equals("+")) {
            return Long.parseLong(num1) + Long.parseLong(num2);
        }

        return Long.parseLong(num1) - Long.parseLong(num2);
    }
}