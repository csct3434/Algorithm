import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;
    private static int N;
    private static int[][] plain, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        plain = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                plain[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        System.out.println(dfs(0, 1));
    }

    private static int dfs(int now, int visit) {
        if (visit == (1 << N) - 1) {
            if (plain[now][0] == 0) return INF;
            return plain[now][0];
        }

        if (dp[now][visit] != -1) return dp[now][visit];

        dp[now][visit] = INF;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && plain[now][i] != 0) {
                dp[now][visit] = Math.min(dp[now][visit], dfs(i, visit | (1 << i)) + plain[now][i]);
            }
        }
        return dp[now][visit];
    }
}