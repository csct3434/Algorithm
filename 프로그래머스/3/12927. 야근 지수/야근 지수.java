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
        
        long answer = 0;
        while(!pq.isEmpty()) {
            long workload = pq.poll();
            answer += workload * workload;
        }
        return answer;
    }
}