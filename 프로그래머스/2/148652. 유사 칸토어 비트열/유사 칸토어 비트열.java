import java.util.stream.*;

class Solution {
    public int solution(int n, long l, long r) {
        long total = (long) Math.pow(4, n);
        if(l > 1)   total -= solve(n, l - 2);
        if(r < Math.pow(5, n))  total -= solve(n, (long) Math.pow(5, n) - r - 1);
        return (int) total;
    }
    
    private long solve(int n, long r) {
        if(n == 1) {
            return r < 2 ? r + 1 : r;
        }
        
        long count = 0;
        long subLen = (long) Math.pow(5, n-1);
        
        long subGroup = r / subLen;
        count += Math.pow(4, n-1) * (subGroup <= 2 ? subGroup : subGroup - 1);
        
        if(r < subLen * 2 || r >= subLen * 3) {
            count += solve(n-1, r % subLen);
        }
        
        return count;
    }
}