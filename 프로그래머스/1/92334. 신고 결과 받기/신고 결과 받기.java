import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length], reportCount = new int[id_list.length];
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) indexMap.put(id_list[i], i);
        Set<String> reportSet = new HashSet<>();
        for(String r : report) reportSet.add(r);
        for(String r : reportSet) reportCount[indexMap.get(r.split(" ")[1])]++;
        for(String r : reportSet) {
            String[] token = r.split(" ");
            if(reportCount[indexMap.get(token[1])] >= k) {
                answer[indexMap.get(token[0])]++;
            }
        }
        return answer;
    }
}