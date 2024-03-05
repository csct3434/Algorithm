class Solution {

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dp = new int[e + 1];
        int[] count = new int[e + 1];

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        int maxCount = count[e];
        dp[e] = e;

        for (int i = e - 1; i >= 1; i--) {
            if (count[i] >= maxCount) {
                dp[i] = i;
                maxCount = count[i];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        for (int i = 0; i < starts.length; i++) {
            answer[i] = dp[starts[i]];
        }
        return answer;
    }

}