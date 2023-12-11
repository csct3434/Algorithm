class Solution {

	public int solution(int n) {
		int answer = 1;

		for (int k = 2; k < n; k++) {
			int base = (k * k + k) / 2;

			if (n < base) {
				break;
			}

			if ((n - base) % k == 0) {
				answer++;
			}
		}

		return answer;
	}
}