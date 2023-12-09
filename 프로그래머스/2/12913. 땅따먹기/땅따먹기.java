class Solution {

	int solution(int[][] land) {
		int rows = land.length;
		int cols = land[0].length;
		int[][] dp = new int[rows][cols];

		init(land, dp, cols);

		for (int x = 1; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				dp[x][y] = land[x][y] + calcMax(dp, x - 1, cols, y);
			}
		}

		return calcMax(dp, rows - 1, cols, -1);
	}

	private void init(int[][] land, int[][] dp, int cols) {
		for (int i = 0; i < cols; i++) {
			dp[0][i] = land[0][i];
		}
	}

	private int calcMax(int[][] dp, int targetRow, int cols, int blockedCol) {
		int max = 0;

		for (int col = 0; col < cols; col++) {
			if (col != blockedCol) {
				max = Math.max(max, dp[targetRow][col]);
			}
		}

		return max;
	}
}