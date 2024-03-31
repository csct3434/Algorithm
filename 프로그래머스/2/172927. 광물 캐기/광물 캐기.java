import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int total = Math.min(Arrays.stream(picks).sum() * 5, minerals.length);
        
        Map<String, Integer> costMap = new HashMap<>();
        costMap.put("diamond", 25);
        costMap.put("iron", 5);
        costMap.put("stone", 1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        
        for(int i=0; i<total; i += 5) {
            int cost = 0;
            for(int j=0; j<5 && i+j < total; j++) {
                cost += costMap.get(minerals[i+j]);
            }
            pq.add(new int[]{i, cost});
        }
        
        Queue<String> availableTools = new LinkedList<>();
        for(int i=0; i<picks[0]; i++)   availableTools.add("diamond");
        for(int i=0; i<picks[1]; i++)   availableTools.add("iron");
        for(int i=0; i<picks[2]; i++)   availableTools.add("stone");
        
        while(!pq.isEmpty() && !availableTools.isEmpty()) {
            String tool = availableTools.poll();
            
            int[] info = pq.poll();
            int start = info[0];
            int end = Math.min(start + 4, total - 1);
            int maxCost = info[1];
            
            if(tool.equals("diamond")) {
                answer += end - start + 1;
            } else if(tool.equals("stone")) {
                answer += maxCost;
            } else {
                for(int i=start; i<=end; i++) {
                    if(minerals[i].equals("diamond"))   answer += 5;
                    else    answer += 1;
                }
            }
        }
        
        return answer;
    }
}