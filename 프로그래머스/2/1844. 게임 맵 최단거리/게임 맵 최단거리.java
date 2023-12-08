import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    private static final int MAX = 100;
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	private int n, m;
	private boolean[][] visited = new boolean[MAX][MAX];

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Node curr = queue.remove();

			for (int i = 0; i < 4; i++) {
				int nx = curr.getX() + dx[i];
				int ny = curr.getY() + dy[i];

				if (canGo(nx, ny, maps)) {
					if (nx == n - 1 && ny == m - 1) {
						return curr.getDistance() + 1;
					}
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny, curr.getDistance() + 1));
				}
			}
		}
		return -1;
	}

	public boolean canGo(int x, int y, int[][] maps) {
		if (!(x >= 0 && x < n && y >= 0 && y < m)) {
			return false;
		}
		return !visited[x][y] && maps[x][y] == 1;
	}
}

class Node {

	private int x;
	private int y;
	private int distance;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance() {
		return distance;
	}

	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
