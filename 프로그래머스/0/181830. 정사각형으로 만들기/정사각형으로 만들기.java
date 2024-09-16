class Solution {
    public int[][] solution(int[][] arr) {
        int N = Math.max(arr.length, arr[0].length);
        int[][] ans = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i >= arr.length || j >= arr[0].length) ans[i][j] = 0;
                else ans[i][j] = arr[i][j];
            }
        }
        return ans;
    }
}