import java.util.LinkedList;

class Solution {

    public int solution(String s) {
        int answer = s.length();

        for (int len = 1; len <= s.length() / 2; len++) {
            LinkedList<String> tokens = new LinkedList<>();

            for (int i = 0; i < s.length(); i += len) {
                tokens.add(s.substring(i, Math.min(i + len, s.length())));
            }

            int idx = 0;
            StringBuilder result = new StringBuilder();
            while (idx < tokens.size()) {
                String token = tokens.get(idx++);

                int count = 1;
                while (idx < tokens.size() && token.equals(tokens.get(idx))) {
                    count++;
                    idx++;
                }

                if (count > 1) {
                    result.append(count);
                }
                result.append(token);
            }

            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}