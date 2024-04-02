class Solution {
    public int solution(int n, long l, long r) {
        if(n == 0)  return 1;
        return (int) (solve(n, r-1) - solve(n, l-2));
    }
    
    public long solve(int n, long r) {
        if(n == 1)  return r < 2 ? r + 1 : r;
        
        long group = r / (long) Math.pow(5, n-1);
        long pos = r % (long) Math.pow(5, n-1);
        long subCount = (long) Math.pow(4, n-1);
        
        if(group == 2)  return subCount * 2;
        if(group < 2)   return subCount * group + solve(n-1, pos);
        return subCount * --group + solve(n-1, pos);
    }
}