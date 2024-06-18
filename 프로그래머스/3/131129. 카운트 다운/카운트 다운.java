import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[100001][2];
        for(int i=1; i<=target; i++) dp[i][0] = Integer.MAX_VALUE;
        Set<Integer> sb = new HashSet<>();
        List<Integer> availableShots = new ArrayList<>();
        for(int i=1; i<=20; i++) {
            sb.add(i);
            dp[i][0] = dp[i][1] = dp[i * 2][0] = dp[i * 3][0] = 1;
            availableShots.addAll(List.of(i, i*2, i*3));
        }
        dp[50][0] = dp[50][1] = 1;
        availableShots.add(50);
        sb.add(50);
        Collections.sort(availableShots, (a, b) -> b - a);
        
        for(int score=23; score<=target; score++) {
            for(int shot : availableShots) {
                int prevScore = score - shot;
                int s = sb.contains(shot) ? 1 : 0;
                if(prevScore < 1 || dp[score][0] < dp[prevScore][0] + 1) continue;
                if(dp[score][0] > dp[prevScore][0] + 1) {
                    dp[score][0] = dp[prevScore][0] + 1;
                    dp[score][1] = dp[prevScore][1] + s;
                } else if(dp[score][1] < dp[prevScore][1] + s) {
                    dp[score][1] = dp[prevScore][1] + s;
                }
            }
        }
        return dp[target];
    }
}