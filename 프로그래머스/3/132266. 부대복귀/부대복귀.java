import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] road : roads) {
            if(!map.containsKey(road[0])) map.put(road[0], new ArrayList<>());
            if(!map.containsKey(road[1])) map.put(road[1], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int[] distance = new int[n+1];
        for(int i=0; i<n+1; i++) distance[i] = -1;
        distance[destination] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        while(!queue.isEmpty()) {
            int src = queue.remove();
            if(!map.containsKey(src)) continue;
            for(int dest : map.get(src)) {
                if(distance[dest] == -1) {
                    distance[dest] = distance[src] + 1;
                    queue.add(dest);
                }
            }
        }
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) answer[i] = distance[sources[i]];
        return answer;
    }
}