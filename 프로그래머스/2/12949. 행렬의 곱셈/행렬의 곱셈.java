class Solution {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int l = arr1.length;
		int m = arr1[0].length;
		int n = arr2[0].length;

		int[][] answer = new int[l][n];
		for (int i = 0; i < l; i++) {
			for (int k = 0; k < n; k++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += arr1[i][j] * arr2[j][k];
				}
				answer[i][k] = sum;
			}
		}

		return answer;
	}
}