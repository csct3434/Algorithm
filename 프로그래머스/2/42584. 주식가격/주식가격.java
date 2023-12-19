import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

	public int[] solution(int[] prices) {
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(m -> -m[0]));
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			while (!pq.isEmpty() && pq.peek()[0] > prices[i]) {
				answer[pq.peek()[1]] = i - pq.peek()[1];
				pq.remove();
			}
			pq.add(new Integer[]{prices[i], i});
		}

		while (!pq.isEmpty()) {
			answer[pq.peek()[1]] = prices.length - 1 - pq.poll()[1];
		}

		return answer;
	}
}