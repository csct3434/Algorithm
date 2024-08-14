import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put('[', 2);
        map.put('{', 3);
        map.put('<', 4);
        map.put(')', -1);
        map.put(']', -2);
        map.put('}', -3);
        map.put('>', -4);
        int value;
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            Stack<Integer> stack = new Stack<>();
            boolean success = true;
            for(char c : br.readLine().toCharArray()) {
                value = map.get(c);
                if (value > 0) {
                    stack.push(value);
                    continue;
                }
                if (stack.peek() + value != 0) {
                    success = false;
                    break;
                }
                stack.pop();
            }
            answer.append("#").append(tc).append(" ").append(success && stack.isEmpty() ? 1 : 0).append("\n");
        }
        System.out.println(answer);
    }
}
