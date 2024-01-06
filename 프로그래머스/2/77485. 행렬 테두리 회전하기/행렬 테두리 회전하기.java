class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = new int[rows][columns];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = ++count;
            }
        }
        count = 0;

        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int minValue = Integer.MAX_VALUE;

            int temp1 = arr[x1][y2];
            for (int col = y2; col > y1; col--) {
                arr[x1][col] = arr[x1][col - 1];
                minValue = Math.min(arr[x1][col], minValue);
            }

            int temp2 = arr[x2][y2];
            for (int row = x2; row > x1 + 1; row--) {
                arr[row][y2] = arr[row - 1][y2];
                minValue = Math.min(arr[row][y2], minValue);
            }
            arr[x1 + 1][y2] = temp1;

            int temp3 = arr[x2][y1];
            for (int col = y1; col < y2 - 1; col++) {
                arr[x2][col] = arr[x2][col + 1];
                minValue = Math.min(arr[x2][col], minValue);

            }
            arr[x2][y2 - 1] = temp2;

            for (int row = x1; row < x2 - 1; row++) {
                arr[row][y1] = arr[row + 1][y1];
                minValue = Math.min(arr[row][y1], minValue);
            }
            arr[x2 - 1][y1] = temp3;

            minValue = Math.min(minValue, temp1);
            minValue = Math.min(minValue, temp2);
            minValue = Math.min(minValue, temp3);

            answer[count++] = minValue;
        }

        return answer;
    }
}