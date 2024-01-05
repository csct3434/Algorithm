import java.util.HashMap;
import java.util.Stack;

class Solution {

    private int answer = 0;
    private final HashMap<Character, Integer> map = new HashMap<>();

    public int solution(String s) {

        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);

        check(s);

        StringBuilder stringBuilder = new StringBuilder(s);
        for (int x = 1; x < s.length(); x++) {
            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);
            check(stringBuilder.toString());
        }

        return answer;
    }

    void check(String s) {
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
                return;
            }
        }

        if (stack.isEmpty()) {
            answer++;
        }
    }

    public static void main(String[] args) {
        int solution = new Solution().solution("{");
        System.out.println(solution);
    }
}