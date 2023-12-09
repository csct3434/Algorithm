class Solution {

	public int solution(int n) {
		int answer = n + 1;
		int countOfN = countOne(n);

		while (countOfN != countOne(answer)) {
			answer++;
		}

		return answer;
	}

	private int countOne(int n) {
		String binaryString = Integer.toBinaryString(n);
		return binaryString.length() - binaryString.replace("1", "").length();
	}
}