class Solution {

	private int[][] isBlocked;
	private int size, answer = 0;

	public int solution(int n) {
		init(n);
		solve(0);
		return answer;
	}

	private void init(int n) {
		size = n;
		isBlocked = new int[n][n];
	}

	public void solve(int row) {
		if (row == size) {
			answer++;
			return;
		}

		for (int col = 0; col < size; col++) {
			if (isBlocked[row][col] == 0) {
				setBlocked(row, col, true);
				solve(row + 1);
				setBlocked(row, col, false);
			}
		}
	}

	private void setBlocked(int row, int col, boolean blocked) {
		int value = blocked ? 1 : -1;

		for (int i = 1; row + i < size; i++) {
			isBlocked[row + i][col] += value;
		}

		for (int i = 1; Math.max(row, col) + i < size; i++) {
			isBlocked[row + i][col + i] += value;
		}

		for (int i = 1; row + i < size && col - i >= 0; i++) {
			isBlocked[row + i][col - i] += value;
		}
	}
}
