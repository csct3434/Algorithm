class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length, M = board[0].length, answer = 0;
        int[][] damage = new int[N+1][M+1];
        for(int[] s : skill) {
            int point = s[0] == 1 ? s[5] : -s[5];
            damage[s[1]][s[2]] += point;
            damage[s[1]][s[4] + 1] -= point;
            damage[s[3] + 1][s[2]] -= point;
            damage[s[3] + 1][s[4] + 1] += point;
        }
        for(int i=0; i<N; i++) for(int j=1; j<M; j++) damage[i][j] += damage[i][j-1];
        for(int i=1; i<N; i++) for(int j=0; j<M; j++) damage[i][j] += damage[i-1][j];        
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) if(board[i][j] - damage[i][j] > 0) answer++;
        return answer;
    }
}