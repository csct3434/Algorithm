class Solution {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr1[0].length;
		int k = arr2[0].length;
		
		int[][] answer = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				int sum = 0;
				for (int l = 0; l < m; l++) {
					sum += arr1[i][l] * arr2[l][j];
				}
				answer[i][j] = sum;
			}
		}

		return answer;
	}
}