import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0, right = 1L * times[times.length - 1] * n;
        
        while(left < right) {
            long mid = (left + right) / 2;
            long capacity = 0;
            
            for(int time : times) {
                capacity += mid / time;
            }
            
            if(capacity >= n) right = mid;
            else    left = mid + 1;
        }
        
        return right;
    }
}