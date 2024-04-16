import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        while(answer < queue1.length * 3) {
            if(sum1 == sum2) {
                return answer;
            } else if(sum1 < sum2) {
                q1.add(q2.peek());
                sum1 += q2.peek();
                sum2 -= q2.poll();
            } else {
                q2.add(q1.peek());
                sum2 += q1.peek();
                sum1 -= q1.poll();
            }
            answer++;
        }
        
        return -1;
    }
}