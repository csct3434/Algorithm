import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dp = new int[n][n][2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j][0] = dp[i][j][1] = 987654321;
            }
        }
        dp[0][0][0] = dp[0][0][1] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int x, y, nx, ny, ncost;
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            x = cur[0];
            y = cur[1];
            for(int i=0; i<4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
                if(i < 2) {
                    ncost = Math.min(dp[x][y][0] + 100, dp[x][y][1] + 600);
                    if(dp[nx][ny][0] > ncost) {
                        dp[nx][ny][0] = ncost;
                        queue.add(new int[]{nx, ny});
                    }
                } else {
                    ncost = Math.min(dp[x][y][0] + 600, dp[x][y][1] + 100);
                    if(dp[nx][ny][1] > ncost) {
                        dp[nx][ny][1] = ncost;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return Math.min(dp[n-1][n-1][0], dp[n-1][n-1][1]);
    }
}