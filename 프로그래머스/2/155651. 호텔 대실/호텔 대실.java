import java.util.*;

class Solution {
    public int solution(String[][] book_time) {        
        int[][] bookTimes = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            bookTimes[i][0] = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            bookTimes[i][1] = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]); 
        }
        
        Arrays.sort(bookTimes, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        
        for(int[] bookTime : bookTimes) {
            if(pq.peek() <= bookTime[0]) {
                pq.poll();
            }
            pq.add(bookTime[1] + 10);
        }
        
        return pq.size();
    }
}