class Solution {

    private int[] count = new int[2];

    public int[] solution(int[][] arr) {
        solve(arr, 0, 0, arr.length);
        return count;
    }

    private void solve(int[][] arr, int x, int y, int size) {
        if (isCompressible(arr, x, y, size)) {
            count[arr[x][y]]++;
            return;
        }

        size /= 2;

        solve(arr, x, y, size);
        solve(arr, x + size, y, size);
        solve(arr, x, y + size, size);
        solve(arr, x + size, y + size, size);
    }

    private boolean isCompressible(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}