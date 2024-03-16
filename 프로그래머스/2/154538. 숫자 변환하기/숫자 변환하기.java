import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x, 0});
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int number = info[0], count = info[1];
            int[] nextNumbers = new int[]{number + n, number * 2, number * 3};
            
            if(number == y) {
                return count;
            }
            
            for(int nextNumber : nextNumbers) {
                if(nextNumber <= y && !visited.contains(nextNumber)) {
                    visited.add(nextNumber);
                    queue.add(new int[]{nextNumber, count + 1});
                }
            }
        }
        
        return -1;
    }
}