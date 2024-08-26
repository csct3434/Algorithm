import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] minCount = new int[26];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for(String k : keymap) {
            for(int i=0; i<k.length(); i++) {
                int offset = k.charAt(i) - 'A';
                minCount[offset] = Math.min(minCount[offset], i + 1);
            }
        }
        int idx = 0;
        for(String target : targets) {
            int total = 0, count = 0;
            boolean valid = true;
            for(int i=0; i<target.length(); i++) {
                if((count = minCount[target.charAt(i) - 'A']) == Integer.MAX_VALUE) {
                    valid = false;
                    break;
                }
                total += count;
            }
            answer[idx++] = valid ? total : -1;
        }
        return answer;
    }
}