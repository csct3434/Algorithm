import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> term = new HashMap<>();
        for (String t : terms) {
            String[] token = t.split(" ");
            term.put(token[0], Integer.valueOf(token[1]));
        }
        int td = convertToInt(today);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] token = privacies[i].split(" ");
            int d = convertToInt(token[0]) + term.get(token[1]) * 28;
            if (td >= d) answer.add(i + 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int convertToInt(String date) {
        String[] token = date.split("\\.");
        return Integer.parseInt(token[0]) * 12 * 28
                + Integer.parseInt(token[1]) * 28
                + Integer.parseInt(token[2]);
    }
}