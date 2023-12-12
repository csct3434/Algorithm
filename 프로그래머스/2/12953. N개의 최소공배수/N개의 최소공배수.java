import java.util.Arrays;

class Solution {

	public int solution(int[] arr) {
		int answer = 0;

		Arrays.sort(arr);
		int LCM = lcm(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			LCM = lcm(LCM, arr[i]);
		}

		return LCM;
	}

	private int lcm(int a, int b) {
		return a * b / gcm(a, b);
	}

	private int gcm(int a, int b) {
		if (b % a == 0) {
			return a;
		}
		return gcm(b % a, a);
	}
}
