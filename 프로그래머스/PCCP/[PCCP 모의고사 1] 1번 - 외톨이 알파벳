import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }
            map.get(c).add(i);
        }

        for (Character c : map.keySet()) {
            List<Integer> position = map.get(c);

            if (position.size() < 2) {
                continue;
            }

            boolean lonely = false;
            for (int i = 0; i + 1 < position.size(); i++) {
                if (position.get(i + 1) - position.get(i) > 1) {
                    lonely = true;
                    break;
                }
            }

            if (lonely) {
                answer.append(c);
            }
        }

        return answer.length() == 0 ? "N" : answer.toString();
    }
}
