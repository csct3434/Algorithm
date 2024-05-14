import java.util.*;

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int[] cores) {
        int lo = 0, hi = (int) Arrays.stream(cores).max().orElse(0) * n / cores.length;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int c = count(mid, n, cores);
            if(c == INF) hi = mid - 1;
            else if(c == -INF) lo = mid + 1;
            else return c;
        }
        
        return -1;
    }
    
    private int count(int time, int n, int[] cores) {
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cores.length; i++) {
            total += time / cores[i] + 1;
            if(time % cores[i] == 0) list.add(i);
        }
        if(total < n) return -INF;
        if(total - list.size() >= n) return INF;
        return list.get(n - (total - list.size()) - 1) + 1;
    }
}