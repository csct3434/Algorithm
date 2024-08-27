import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            rank.put(players[i], i);
            answer[i] = players[i];
        }
        for(String calling : callings) {
            int idx = rank.get(calling);
            String temp = answer[idx];
            answer[idx] = answer[idx - 1];
            answer[idx - 1] = temp;
            rank.put(answer[idx], idx);
            rank.put(answer[idx-1], idx-1);
        }
        return answer;
    }
}
