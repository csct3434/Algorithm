import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(List.of(gems)).size();
        Map<String, Integer> count = new HashMap<>();
        int right = -1;
        while(count.keySet().size() != kind) {
            count.put(gems[++right], count.getOrDefault(gems[right], 0) + 1);
        }
        int[] answer = new int[]{1, right + 1};
        for(int left = 1; left < gems.length; left++) {
            String removed = gems[left - 1];
            count.put(removed, count.get(removed) - 1);
            if(count.get(removed) == 0) count.remove(removed);
            while(count.keySet().size() < kind && right + 1 < gems.length) {
                count.put(gems[++right], count.getOrDefault(gems[right], 0) + 1);
            }
            if(count.keySet().size() != kind) break;
            if(right - left < answer[1] - answer[0]) {
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }
        return answer;
    }
}