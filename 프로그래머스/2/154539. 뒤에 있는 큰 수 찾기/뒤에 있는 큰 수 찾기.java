import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for(int i=0; i<numbers.length; i++) {
            int number = numbers[i];
            while(!pq.isEmpty() && pq.peek()[0] < number) {
                answer[pq.poll()[1]] = number;
            }
            pq.add(new int[]{number, i});
        }
        
        while(!pq.isEmpty()) {
            answer[pq.poll()[1]] = -1;
        }
        
        return answer;
    }
}