import java.util.PriorityQueue;

class Solution {

	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int scv : scoville) {
			pq.add(1L * scv);
		}

		while (pq.size() > 1) {
			if (pq.peek() >= K) {
				return answer;
			}

			Long scv1 = pq.poll();
			Long scv2 = pq.poll();
			pq.add(scv1 + scv2 * 2);
			answer++;
		}

		return pq.peek() >= K ? answer : -1;
	}
}