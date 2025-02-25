import java.io.*;
import java.util.*;

public class Main {

    private static final int UNREACHABLE = Integer.MAX_VALUE - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][4];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], UNREACHABLE);
        }
        dp[0][0] = 0;

        for (int k = 1; k <= K; k++) {

            if (k >= A) {
                for (int i = 0; i < 4; i++) {
                    dp[k][i] = Math.min(dp[k][i], dp[k - A][(i + 1) % 4] + 1);
                }
            }

            if (k >= B) {
                for (int i = 0; i < 4; i++) {
                    dp[k][i] = Math.min(dp[k][i], dp[k - B][(i + 3) % 4] + 1);
                }
            }

            if (k >= C) {
                for (int i = 0; i < 4; i++) {
                    dp[k][i] = Math.min(dp[k][i], dp[k - C][(i + 2) % 4] + 1);
                }
            }
        }

        System.out.print(dp[K][0] == UNREACHABLE ? -1 : dp[K][0]);
    }
}
