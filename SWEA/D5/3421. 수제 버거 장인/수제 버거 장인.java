import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    private static int count, T, N, M;
    private static boolean[][] banned;
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            selected = new int[N + 1];
            banned = new boolean[N + 1][N + 1];
            int a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                banned[a][b] = banned[b][a] = true;
            }
            count = 0;
            dfs(0, 1);
            answer.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.print(answer);
    }

    private static void dfs(int depth, int number) {
        if (depth <= N) {
            count++;
            for (int i = number; i <= N; i++) {
                if (check(depth, i)) {
                    selected[depth] = i;
                    dfs(depth + 1, i + 1);
                }
            }
        }
    }

    private static boolean check(int depth, int idx) {
        for (int i = 0; i < depth; i++) {
            if (banned[idx][selected[i]]) return false;
        }
        return true;
    }
}
