import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0, total = sticker.length;
        int[][] dp = new int[total][2];
        
        if(sticker.length == 1) {
            return sticker[0];
        }
        
        dp[0][1] = sticker[0];
        for(int i=1; i < total - 1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = sticker[i] + dp[i-1][0];
        }
        answer = Math.max(dp[total - 2][0], dp[total - 2][1]);
        
        dp[0][1] = 0;
        for(int i=1; i<total; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = sticker[i] + dp[i-1][0];
        }
        answer = Math.max(answer, Math.max(dp[total - 1][0], dp[total - 1][1]));
        
        return answer;
    }
}