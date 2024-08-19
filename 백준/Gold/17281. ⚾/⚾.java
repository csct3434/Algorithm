import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] score;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        score = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[9];
        visited[0] = true;
        int[] player = new int[9];
        player[3] = 0;
        dfs(0, visited, player);
        System.out.println(answer);
    }

    private static void dfs(int depth, boolean[] visited, int[] player) {
        if (depth == 3) {
            dfs(depth + 1, visited, player);
            return;
        }
        if (depth == 9) {
            calcScore(player);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                player[depth] = i;
                dfs(depth + 1, visited, player);
                visited[i] = false;
            }
        }
    }

    private static void calcScore(int[] player) {
        int status, out, distance, count, totalScore = 0, turn = 0;
        for (int round = 0; round < N; round++) {
            status = out = 0;
            while (out < 3) {
                distance = score[round][player[(turn++) % 9]];
                if (distance == 0) {
                    out++;
                    continue;
                }
                count = 0;
                if (distance == 4) {
                    count++;
                }
                for (int i = 0; i <= Math.min(3, distance) - 1; i++) {
                    if ((status & (1 << (2 - i))) > 0) {
                        count++;
                    }
                }
                totalScore += count;
                if (distance == 4) {
                    status = 0;
                } else {
                    status = (status << distance) | (1 << (distance - 1));
                }
            }
        }
        answer = Math.max(answer, totalScore);
    }
}
