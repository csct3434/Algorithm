import java.util.stream.IntStream;

class Solution {

    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int total = dungeons.length;

        boolean[] visited = new boolean[total];
        solve(total, 0, 0, visited, dungeons, k);

        return answer;
    }

    private void solve(int total, int count, int repetition, boolean[] visited, int[][] dungeons, int pirodo) {
        boolean canGoAnywhere = IntStream.range(0, total)
            .anyMatch(i -> !visited[i] && dungeons[i][0] <= pirodo);

        if (total == repetition || !canGoAnywhere) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < total; i++) {
            if (!visited[i] && dungeons[i][0] <= pirodo) {
                visited[i] = true;
                solve(total, count + 1, repetition + 1, visited, dungeons, pirodo - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}