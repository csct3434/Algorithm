import java.util.*;

class Solution {
    
    private boolean visited[][];
    private List<Integer> answer = new LinkedList<>();
    
    private int[] dr = new int[]{1, -1, 0, 0};
    private int[] dc = new int[]{0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        int rows = maps.length, cols = maps[0].length();
        int[][] map = new int[rows][cols];
        visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(maps[i].charAt(j) == 'X')  map[i][j] = 0;
                else    map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j, map, rows, cols);
                }
            }
        }
        
        return answer.size() == 0 ? new int[]{-1} : 
            answer.stream().sorted().mapToInt(x -> x).toArray();
    }
    
    private void bfs(int row, int col, int[][] map, int rows, int cols) {
        int count = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        
        while(!queue.isEmpty()) {            
            int[] info = queue.poll();
            int r = info[0], c = info[1];
            
            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if((nr >= 0 && nr < rows && nc >= 0 && nc < cols) && !visited[nr][nc] && map[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
            
            count += map[r][c];
        }
        
        answer.add(count);
    }
}