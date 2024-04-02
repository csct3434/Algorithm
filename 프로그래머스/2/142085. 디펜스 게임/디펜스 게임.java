import java.util.*;

class Solution {

    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(enemy[i]);
        }
        
        for (int i = k; i < enemy.length; i++) {
            if(enemy[i] <= pq.peek()) {
                n -= enemy[i];
            } else {
                n -= pq.poll();
                pq.add(enemy[i]);
            }
            
            if(n < 0) {
                return i;
            }
        }

        return enemy.length;
    }
}