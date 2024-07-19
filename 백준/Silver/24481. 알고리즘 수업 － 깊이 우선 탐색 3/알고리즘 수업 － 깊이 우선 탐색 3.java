import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		List<PriorityQueue<Integer>> adjacentList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjacentList.add(new PriorityQueue<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjacentList.get(n1).add(n2);
			adjacentList.get(n2).add(n1);
		}
		boolean[] visited = new boolean[N+1];
		int[] answer = new int[N+1];
		for (int i = 1; i <= N; i++) answer[i] = -1;
		dfs(adjacentList, visited, answer, R, 0);
		for (int i = 1; i <= N; i++) System.out.println(answer[i]);
	}

	private static void dfs(List<PriorityQueue<Integer>> adjacentList, boolean[] visited, int[] answer, int node, int depth) {
		visited[node] = true;
		answer[node] = depth;
		PriorityQueue<Integer> adjacentNodes = adjacentList.get(node);
		while (!adjacentNodes.isEmpty()) {
			int n = adjacentNodes.remove();
			if (!visited[n]) {
				dfs(adjacentList, visited, answer, n, depth + 1);
			}
		}
	}
}