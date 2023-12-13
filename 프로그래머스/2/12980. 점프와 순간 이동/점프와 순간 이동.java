public class Solution {

	public int solution(int n) {
		if (n <= 2) {
			return 1;
		}
		
		if (n % 2 == 0) {
			return solution(n / 2);
		}
		return solution(n / 2) + 1;
	}
}