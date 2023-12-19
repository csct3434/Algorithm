import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(m -> -m));
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(i);
			pq.add(priorities[i]);
		}

		while (queue.size() > 1) {
			if (pq.peek() > priorities[queue.peek()]) {
				queue.add(queue.poll());
				continue;
			}

			answer++;
			if (pq.peek() == priorities[queue.peek()]) {
				pq.remove();
			}

			if (queue.poll() == location) {
				return answer;
			}
		}

		return priorities.length;
	}
}