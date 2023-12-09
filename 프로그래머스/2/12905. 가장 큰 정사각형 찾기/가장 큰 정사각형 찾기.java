class Solution {

	private int rows;
	private int cols;

	public int solution(int[][] board) {
		int answer = 0;

		rows = board.length;
		cols = board[0].length;
		int[][] dp = new int[rows + 1][cols + 1];

		init(board, rows, cols, dp);

		for (int x = 1; x <= rows; x++) {
			for (int y = 1; y <= cols; y++) {
				if (dp[x][y] != 1) {
					continue;
				}

				dp[x][y] = 1 + Math.min(
					Math.min(dp[x - 1][y - 1], dp[x - 1][y]), dp[x][y - 1]);

				answer = Math.max(answer, dp[x][y] * dp[x][y]);
			}
		}

		return answer;
	}

	private void init(int[][] board, int rows, int cols, int[][] dp) {
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				dp[x + 1][y + 1] = board[x][y];
			}
		}
	}
}