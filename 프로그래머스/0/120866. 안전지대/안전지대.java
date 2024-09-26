class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = n * n;
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(board[x][y] != 1) continue;
                answer--;
                for(int i=0; i<8; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                        answer--;
                    }
                }
            }
        }
        return answer;
    }
}