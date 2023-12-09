class Solution {

	public int solution(int n) {
		int answer = 0, beforeSecond = 0, beforeFirst = 1;

		for (int i = 2; i <= n; i++) {
			answer = (beforeSecond + beforeFirst) % 1234567;
			beforeSecond = beforeFirst;
			beforeFirst = answer;
		}

		return answer;
	}
}