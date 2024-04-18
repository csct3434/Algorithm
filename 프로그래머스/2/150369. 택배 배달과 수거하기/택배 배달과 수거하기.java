import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        PriorityQueue<int[]> deliveryPQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        PriorityQueue<int[]> pickupPQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        
        for(int i=0; i<deliveries.length; i++) {
            if(deliveries[i] > 0) deliveryPQ.add(new int[]{i+1, deliveries[i]});
            if(pickups[i] > 0) pickupPQ.add(new int[]{i+1, pickups[i]});
        }
        
        while(!(deliveryPQ.isEmpty() && pickupPQ.isEmpty())) {
            int capacity = cap;
            answer += 2 * Math.max(deliveryPQ.isEmpty() ? 0 : deliveryPQ.peek()[0], 
                               pickupPQ.isEmpty() ? 0 : pickupPQ.peek()[0]);
            
            while(!deliveryPQ.isEmpty() && capacity > 0) {
                if(deliveryPQ.peek()[1] <= capacity) {
                    capacity -= deliveryPQ.peek()[1];
                    deliveryPQ.poll();
                } else {
                    deliveryPQ.peek()[1] -= capacity;
                    capacity = 0;
                }
            }
            
            capacity = cap;
            while(!pickupPQ.isEmpty() && capacity > 0) {
                if(pickupPQ.peek()[1] <= capacity) {
                    capacity -= pickupPQ.peek()[1];
                    pickupPQ.poll();
                } else {
                    pickupPQ.peek()[1] -= capacity;
                    capacity = 0;
                }
            }
        }
        
        return answer;
    }
}