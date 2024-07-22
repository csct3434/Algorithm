import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Map<Integer, Stack<Integer>> map = new HashMap<>();
		int n, p, answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			if (!map.containsKey(n)) {
				map.put(n, new Stack<>());
			}
			Stack<Integer> stack = map.get(n);
			while (!stack.isEmpty() && stack.peek() > p) {
				stack.pop();
				answer++;
			}
			if (stack.isEmpty() || stack.peek() != p) {
				stack.push(p);
				answer++;
			}
		}
		System.out.println(answer);
	}
}