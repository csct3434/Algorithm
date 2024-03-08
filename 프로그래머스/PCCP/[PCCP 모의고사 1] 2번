class Solution {

    private int answer = 0;

    public int solution(int[][] ability) {
        dfs(0, ability, new boolean[ability.length], new int[ability[0].length]);
        return answer;
    }

    private void dfs(int step, int[][] ability, boolean[] visited, int[] sequence) {
        if (step == sequence.length) {
            int score = 0;
            for (int i = 0; i < sequence.length; i++) {
                score += ability[sequence[i]][i];
            }
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[step] = i;
                dfs(step + 1, ability, visited, sequence);
                visited[i] = false;
            }
        }
    }
}
