import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0, count = 0, total = (n * n - n) / 2;
        parent = new int[n + 1];
        
        for(int i=1; i<=n; i++) parent[i] = i;
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        
        for(int[] cost : costs) {
            int px = find(cost[0]);
            int py = find(cost[1]);
            
            if(px != py) {
                union(px, py);
                answer += cost[2];
                
                if(++count == total) {
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private void union(int x, int y) {
        if(x <= y) parent[y] = x;
        else parent[x] = y;
    }
    
    private int find(int x) {
        if(x == parent[x])  return x;
        return find(parent[x]);
    }
}