class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int i = 0, num = 1, x = 0, y = -1;
        while(num <= n * n) {
            while(true) {
                int nx = x + dx[i % 4];
                int ny = y + dy[i % 4];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) break;
                x = nx;
                y = ny;
                answer[x][y] = num++;
            }
            i++;
        }
        return answer;
    }
}