import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i=0; i<works.length; i++) {
            pq.add(works[i]);
        }
        
        while(n-- > 0 && !pq.isEmpty()) {
            int workload = pq.poll();
            if(workload > 1) {
                pq.add(workload - 1);
            }
        }
        
        return pq.stream().mapToLong(i -> (long) i * i).sum();
    }
}