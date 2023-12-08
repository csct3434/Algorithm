class Solution {

	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	private boolean[][] visited = new boolean[100][100];
	private int sizeOfArea;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					numberOfArea++;
					sizeOfArea = 0;

					dfs(i, j, m, n, picture);

					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private void dfs(int x, int y, final int m, final int n, final int[][] picture) {
		visited[x][y] = true;
		sizeOfArea++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (canGo(nx, ny, m, n, picture, picture[x][y])) {
				dfs(nx, ny, m, n, picture);
			}
		}
	}

	private boolean canGo(int x, int y, int m, int n, int[][] picture, int color) {
		if(!(x >= 0 && x < m && y >= 0 && y < n)) {
			return false;
		}
		return !visited[x][y] && picture[x][y] == color;
	}
}