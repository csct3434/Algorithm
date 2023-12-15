class Solution {

	public String solution(int n, int t, int m, int p) {
		int num = 0, order = 1;
		StringBuilder answer = new StringBuilder();

		if (m == p) {
			p = 0;
		}

		while (answer.length() != t) {
			String converted = Integer.toString(num++, n);
			for (char c : converted.toCharArray()) {
				if (order++ % m == p) {
					answer.append(c);
					if (answer.length() == t) {
						break;
					}
				}
			}
		}
		return answer.toString().toUpperCase();
	}
}
