class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] blocked = new boolean[n+1][m+1];
        for(int[] puddle : puddles) {
            blocked[puddle[1]][puddle[0]] = true;
        }
        
        int[][] dp = new int[n+1][m+1];
        for(int col = 1; col <= m; col++) {
            if(blocked[1][col]) {
                break;
            }
            dp[1][col] = 1;
        }
        
        for(int row = 2; row <= n; row++) {
            for(int col = 1; col <= m; col++) {
                if(!blocked[row][col]) {
                    dp[row][col] = (dp[row-1][col] + dp[row][col-1]) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}