class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0, n = board.length, m = board[0].length;
        for(int i=0; i<n; i++)
            for(int j=0; i + j <= k && j < m; j++)
                answer += board[i][j];
        return answer;
    }
}