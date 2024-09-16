class Solution {
    
    private int[][] dp;
    
    public int solution(int balls, int share) {
        dp = new int[balls+1][balls+1];
        return comb(balls, share);
    }
    
    private int comb(int n, int r) {
        if(dp[n][r] != 0) return dp[n][r];
        if(r == 0 || r == n) return 1;
        return dp[n][r] = comb(n-1, r) + comb(n-1, r-1);
    }
}