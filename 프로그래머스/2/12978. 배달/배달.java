import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	public int solution(int N, int[][] road, int K) {
		List<List<int[]>> graph = new ArrayList<>();
		int[] distance = new int[N + 1];

		init(graph, distance, road, N);

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[]{1, 0});
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDistance = curr[1];

			for (int[] edge : graph.get(currNode)) {
				int nextNode = edge[0];
				int nextDistance = currDistance + edge[1];

				if (nextDistance < distance[nextNode]) {
					distance[nextNode] = nextDistance;
					pq.add(new int[]{nextNode, nextDistance});
				}
			}
		}

		return (int) Arrays.stream(distance)
			.filter(dist -> dist <= K)
			.count();
	}

	private void init(List<List<int[]>> graph, int[] distance, int[][] road, int N) {
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int dist = road[i][2];
			graph.get(from).add(new int[]{to, dist});
			graph.get(to).add(new int[]{from, dist});
		}
        
		for (int i = 0; i < N + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[1] = 0;
	}
}