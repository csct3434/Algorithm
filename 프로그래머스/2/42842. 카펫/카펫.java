class Solution {

	public int[] solution(int brown, int yellow) {
		int total = brown + yellow;

		for (int i = 3; i * i <= total; i++) {
			if (total % i != 0) {
				continue;
			}
			
			int height = i;
			int width = total / i;
			
			if ((height - 2) * (width - 2) == yellow) {
				return new int[]{width, height};
			}
		}

		return new int[]{-1, -1};
	}
}