import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0, idx = 0, completed = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        while(completed < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()) {
                time++;
            } else {                
                int[] job = pq.poll();
                answer += time - job[0] + job[1];
                time += job[1];
                completed++;
            }
        }
        
        return answer / jobs.length;
    }
}