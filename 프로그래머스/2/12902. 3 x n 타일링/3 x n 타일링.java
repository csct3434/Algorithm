class Solution {

	public int solution(int n) {
		Long[] dp = new Long[n + 1];
		dp[2] = 3L;
		dp[4] = 11L;

		for (int i = 6; i <= n; i += 2) {
			dp[i] = ((((4 * dp[i - 2]) % 1000000007) - ((dp[i - 4]) % 1000000007)) + 1000000007) % 1000000007;
		}

		return dp[n].intValue();
	}
}
