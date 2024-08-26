class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0, n = board.length;
        int[] dh = {1, -1, 0, 0}, dw = {0, 0, 1, -1};
        for(int i=0; i<4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            if(nh >= 0 && nh < n && nw >= 0 && nw < n && board[nh][nw].equals(board[h][w])) answer++;
        }
        return answer;
    }
}