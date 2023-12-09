import java.util.LinkedList;

class Solution {

	public String solution(int n) {
		LinkedList<String> answer = new LinkedList<>();

		while (n > 0) {
			int remainder = n % 3;

			if (remainder == 0) {
				answer.add(0, "4");
				n -= 3;
			} else {
				answer.add(0, String.valueOf(remainder));
				n -= remainder;
			}
			n /= 3;
		}

		return answer.stream().reduce(String::concat).orElse("");
	}
}