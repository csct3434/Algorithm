class Solution {

	public int solution(int n) {
		int answer = n + 1;
		int countOfN = Integer.bitCount(n);

		while (countOfN != Integer.bitCount(answer)) {
			answer++;
		}

		return answer;
	}
}