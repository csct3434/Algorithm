import java.util.*;

class Solution {
    
    private static final int[] dx = new int[]{1, -1, 0, 0};
    private static final int[] dy = new int[]{0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int[] start = new int[2], lever = new int[2], exit = new int[2];
        char[][] map = new char[maps.length][];
        
        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == 'S') {
                    start[0] = i; start[1] = j;
                } else if(map[i][j] == 'E') {
                    exit[0] = i; exit[1] = j;
                } else if(map[i][j] == 'L') {
                    lever[0] = i; lever[1] = j;
                }
            }
        }
        
        int toLever = bfs(map, start, lever);
        int toExit = bfs(map, lever, exit);
        
        return (toLever < 0 || toExit < 0) ? -1 : toLever + toExit;
    }
    
    private int bfs(char[][] map, int[] src, int[] dest) {
        int rows = map.length, cols = map[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{src[0], src[1], 0});
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0], y = info[1], distance = info[2];
            
            if(x == dest[0] && y == dest[1]) {
                return distance;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}