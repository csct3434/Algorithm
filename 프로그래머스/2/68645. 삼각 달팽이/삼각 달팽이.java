class Solution {

    public int[] solution(int n) {
        int total = n * (1 + n) / 2;
        int[] answer = new int[n * (1 + n) / 2];
        int[][] array = new int[n][n];

        int row = 0, col = 0, count = 1, repeat = 0;
        while (count <= total) {
            for (; row < n - repeat; row++) {
                array[row][col] = count++;
            }
            row--;

            col++;
            for (; col <= row - repeat; col++) {
                array[row][col] += count++;
            }
            col--;

            while (row - 1 >= 1 + repeat * 2) {
                array[--row][--col] += count++;
            }
            row++;
            repeat++;
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