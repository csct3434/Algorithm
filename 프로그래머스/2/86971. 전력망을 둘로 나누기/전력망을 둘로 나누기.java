class Solution {

    public int solution(int n, int[][] wires) {
        int answer = n;

        int[] count = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        boolean[][] adjacentMatrix = new boolean[n + 1][n + 1];

        initAdjacentMatrix(adjacentMatrix, wires);

        dfs(n, 1, count, visited, adjacentMatrix);

        for (int[] wire : wires) {
            int subsetCount = Math.min(count[wire[0]], count[wire[1]]);
            answer = Math.min(answer, Math.abs(subsetCount - (n - subsetCount)));
        }

        return answer;
    }

    private void initAdjacentMatrix(boolean[][] adjacentMatrix, int[][] wires) {
        for (int[] wire : wires) {
            adjacentMatrix[wire[0]][wire[1]] = true;
            adjacentMatrix[wire[1]][wire[0]] = true;
        }
    }

    private int dfs(int n, int node, int[] count, boolean[] visited, boolean[][] adjacentMatrix) {
        visited[node] = true;

        int childCount = 0;
        for (int i = 1; i <= n; i++) {
            if (adjacentMatrix[node][i] && !visited[i]) {
                childCount += dfs(n, i, count, visited, adjacentMatrix);
            }
        }

        return count[node] = childCount + 1;
    }
}
