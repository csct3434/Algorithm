import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    private Map<Integer, Integer> countsPerSector = new HashMap<>();
    private int[][] sectorInfo;
    private boolean[][] visited;

    public int solution(int[][] land) {
        int answer = 0;
        int rows = land.length;
        int cols = land[0].length;

        sectorInfo = new int[rows][cols];
        visited = new boolean[rows][cols];

        int sectorNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (land[row][col] == 1 && sectorInfo[row][col] == 0) {
                    bfs(land, rows, cols, row, col, sectorNumber++);
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            int totalCount = 0;
            HashSet<Integer> visitedSector = new HashSet<>();

            for (int row = 0; row < rows; row++) {
                int sector = sectorInfo[row][col];
                if (land[row][col] == 1 && !visitedSector.contains(sector)) {
                    totalCount += countsPerSector.get(sector);
                    visitedSector.add(sector);
                }
            }

            answer = Math.max(answer, totalCount);
        }

        return answer;
    }

    private void bfs(int[][] land, int rows, int cols, int row, int col, int sectorNumber) {
        Queue<Matrix> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 0;
        visited[row][col] = true;
        sectorInfo[row][col] = sectorNumber;
        queue.add(new Matrix(row, col));
        
        while (!queue.isEmpty()) {
            count++;

            Matrix matrix = queue.poll();
            int x = matrix.row;
            int y = matrix.col;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(nx >= 0 && nx < rows && ny >= 0 && ny < cols)) {
                    continue;
                }

                if (!visited[nx][ny] && land[nx][ny] == 1) {
                    queue.add(new Matrix(nx, ny));
                    visited[nx][ny] = true;
                    sectorInfo[nx][ny] = sectorNumber;
                }
            }
        }

        countsPerSector.put(sectorNumber, count);
    }

    private static class Matrix {

        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}