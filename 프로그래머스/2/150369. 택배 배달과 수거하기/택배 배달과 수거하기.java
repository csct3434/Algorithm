import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<int[]> dS = new Stack<>();
        Stack<int[]> pS = new Stack<>();
        
        for(int i=0; i<deliveries.length; i++) {
            if(deliveries[i] > 0) dS.push(new int[]{i+1, deliveries[i]});
            if(pickups[i] > 0) pS.push(new int[]{i+1, pickups[i]});
        }
        
        while(!(dS.isEmpty() && pS.isEmpty())) {
            int capacity = cap;
            answer += 2 * Math.max(dS.isEmpty() ? 0 : dS.peek()[0], pS.isEmpty() ? 0 : pS.peek()[0]);
            
            while(!dS.isEmpty() && capacity > 0) {
                if(dS.peek()[1] <= capacity) {
                    capacity -= dS.peek()[1];
                    dS.pop();
                } else {
                    dS.peek()[1] -= capacity;
                    capacity = 0;
                }
            }
            
            capacity = cap;
            while(!pS.isEmpty() && capacity > 0) {
                if(pS.peek()[1] <= capacity) {
                    capacity -= pS.peek()[1];
                    pS.pop();
                } else {
                    pS.peek()[1] -= capacity;
                    capacity = 0;
                }
            }
        }
        
        return answer;
    }
}