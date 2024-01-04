class Solution {

    public int[] solution(int n) {
        int total = n * (1 + n) / 2;
        int[][] array = new int[n][n];
        int[] answer = new int[n * (1 + n) / 2];

        int row = -1, col = 0, count = 0;
        while (count < total) {
            while (row + 1 < n && array[row + 1][col] == 0) {
                array[++row][col] = ++count;
            }

            while (col + 1 < n && array[row][col + 1] == 0) {
                array[row][++col] = ++count;
            }

            while ((row - 1 >= 0 && col - 1 >= 0) && array[row - 1][col - 1] == 0) {
                array[--row][--col] = ++count;
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[count++] = array[i][j];
            }
        }

        return answer;
    }
}