class Solution {
    
    int MOD = 20170805;
    int BLOCKED = 1, STRAIGHT_ONLY = 2;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp = new int[m][n][2];
        for(int i=1; i<m && cityMap[i][0] != BLOCKED; i++) dp[i][0][0] = 1;
        for(int i=1; i<n && cityMap[0][i] != BLOCKED; i++) dp[0][i][1] = 1;
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(cityMap[i][j] == BLOCKED) continue;
                dp[i][j][0] += dp[i-1][j][0];
                if(cityMap[i-1][j] != STRAIGHT_ONLY) dp[i][j][0] += dp[i-1][j][1];
                dp[i][j][1] += dp[i][j-1][1];
                if(cityMap[i][j-1] != STRAIGHT_ONLY) dp[i][j][1] += dp[i][j-1][0];
                dp[i][j][0] %= MOD;
                dp[i][j][1] %= MOD;
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}