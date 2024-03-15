import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, last = -30001;
        
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        for(int[] route : routes) {
            if(route[0] > last) {
                last = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}