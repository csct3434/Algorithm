import java.util.HashMap;
import java.util.Stack;

class Solution {

    private final HashMap<Character, Integer> map = new HashMap<>();

    public int solution(String s) {
        int answer = 0;

        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);

        StringBuilder stringBuilder = new StringBuilder(s);
        for (int x = 0; x < s.length(); x++) {
            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);
            if (check(stringBuilder.toString())) {
                answer++;
            }
            ;
        }
        return answer;
    }

    boolean check(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            Integer value = map.get(c);

            if (value > 0) {
                stack.push(value);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() + value == 0) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}