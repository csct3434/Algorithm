class Solution {
        
    public long solution(int[] sequence) {
        long[] dp = new long[]{sequence[0], -sequence[0]};
        long answer = Math.max(dp[0], dp[1]);
        for(int i=1; i<sequence.length; i++) {
            long positive = Math.max(dp[1] + sequence[i], sequence[i]);
            long negative = Math.max(dp[0] - sequence[i], -sequence[i]);
            dp[0] = positive;
            dp[1] = negative;
            answer = Math.max(answer, Math.max(dp[0], dp[1]));
        }
        return answer;
    }
}