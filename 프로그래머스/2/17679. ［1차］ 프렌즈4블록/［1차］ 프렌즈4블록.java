class Solution {

	public int solution(int m, int n, String[] b) {
		char[][] board = new char[m][n];
		for (int i = 0; i < m; i++) {
			board[i] = b[i].toCharArray();
		}
		return solve(m, n, board);
	}

	public int solve(int m, int n, char[][] board) {
		int count = 0;
		boolean[][] mark = new boolean[m][n];

		int[] dx = {0, 0, 1, 1};
		int[] dy = {0, 1, 0, 1};

		for (int x = 0; x < m - 1; x++) {
			for (int y = 0; y < n - 1; y++) {
				char friend = board[x][y];
				if (friend == '.') {
					continue;
				}

				boolean pop = true;
				for (int i = 0; i < 4; i++) {
					if (friend != board[x + dx[i]][y + dy[i]]) {
						pop = false;
					}
				}

				if (pop) {
					for (int i = 0; i < 4; i++) {
						mark[x + dx[i]][y + dy[i]] = true;
					}
				}
			}
		}

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (mark[x][y]) {
					count++;
					board[x][y] = '.';
				}
			}
		}

		for (int y = 0; y < n; y++) {
			for (int x = m - 2; x >= 0; x--) {
				if (board[x][y] == '.') {
					continue;
				}

				for (int i = m - 1; i > x; i--) {
					if (board[i][y] == '.') {
						board[i][y] = board[x][y];
						board[x][y] = '.';
					}
				}
			}
		}

		if (count == 0) {
			return 0;
		}
		return count + solve(m, n, board);
	}
}