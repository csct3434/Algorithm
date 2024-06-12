class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n+1][n+1];
        for(int[] result : results) {
            arr[result[0]][result[1]] = 1;
            arr[result[1]][result[0]] = -1;
        }
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(arr[i][j] == 0 && arr[i][k] != 0 && arr[k][j] == arr[i][k]) {
                        arr[i][j] = arr[i][k];
                    }
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++) {
            boolean flag = true;
            for(int j=1; j<=n; j++) {
                if(i != j && arr[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
