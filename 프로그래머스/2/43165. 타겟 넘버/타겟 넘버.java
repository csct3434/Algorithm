class Solution {

	public int solution(int[] numbers, int target) {
		int answer = 0;
		int len = numbers.length;
		int total = 1 << len;

		for (int mask = 0; mask < total; mask++) {
			int sum = 0;
			for (int i = 0; i < len; i++) {
				if ((mask & (1 << i)) == 0) {
					sum += numbers[i];
				} else {
					sum -= numbers[i];
				}
			}
			if (sum == target) {
				answer++;
			}
		}
		return answer;
	}
}