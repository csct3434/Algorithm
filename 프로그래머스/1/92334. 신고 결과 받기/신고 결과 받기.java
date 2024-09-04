import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length], reportCount = new int[id_list.length];
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) indexMap.put(id_list[i], i);
        Arrays.stream(report).distinct().forEach(s -> reportCount[indexMap.get(s.split(" ")[1])]++);
        Arrays.stream(report).distinct().filter(s -> reportCount[indexMap.get(s.split(" ")[1])] >= k)
            .forEach(t -> answer[indexMap.get(t.split(" ")[0])]++);
        return answer;
    }
}