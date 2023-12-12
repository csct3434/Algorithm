import java.util.ArrayList;
import java.util.List;

class Solution {

	private List<int[]> result = new ArrayList<>();

	public int[][] solution(int n) {
		move(n, 1, 3, 2);

		int[][] answer = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

	public void move(int count, int from, int to, int mid) {
		if (count == 0) {
			return;
		}
		move(count - 1, from, mid, to);
		result.add(new int[]{from, to});
		move(count - 1, mid, to, from);
	}
}