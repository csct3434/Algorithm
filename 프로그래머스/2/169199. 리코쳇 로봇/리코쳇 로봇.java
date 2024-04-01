import java.util.*;

class Solution {
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        int[] start = new int[2];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        
        visited[start[0]][start[1]] = true;
        queue.add(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0], y = info[1], count = info[2];
            
            if(board[x].charAt(y) == 'G') {
                return count;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x, ny = y;
                
                while((nx >= 0 && nx < rows && ny >= 0 && ny < cols) && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        
        return -1;
    }
}