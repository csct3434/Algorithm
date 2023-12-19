import java.util.ArrayList;

class Solution {

	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] finishTime = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++) {
			finishTime[i] = (int) Math.ceil((100D - progresses[i]) / speeds[i]);
		}

		for (int i = 0; i < progresses.length; i++) {
			int count = 1;
			int finish = finishTime[i];

			for (int j = i + 1; j < progresses.length; j++) {
				if (finishTime[j] <= finish) {
					count++;
					i++;
					continue;
				}
				break;
			}
			answer.add(count);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}