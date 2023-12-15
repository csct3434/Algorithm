class Solution {

	public String solution(int n, int t, int m, int p) {
		int num = 0, order = 1;
		StringBuilder answer = new StringBuilder();

		if (m == p) {
			p = 0;
		}

		while (answer.length() != t) {
			String converted = convertTo(num++, n);
			for (char c : converted.toCharArray()) {
				if (order++ % m == p) {
					answer.append(c);
					if (answer.length() == t) {
						break;
					}
				}
			}
		}
		return answer.toString();
	}

	private String convertTo(int num, int n) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

		if (num == 0) {
			return "0";
		}

		while (num > 0) {
			stringBuilder.insert(0, c[num % n]);
			num /= n;
		}
		return stringBuilder.toString();
	}
}
