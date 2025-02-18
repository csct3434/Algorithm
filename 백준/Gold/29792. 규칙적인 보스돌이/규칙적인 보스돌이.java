import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] D = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            D[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(D);

        long[] P = new long[K + 1];
        int[] Q = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            P[i] = Long.parseLong(st.nextToken());
            Q[i] = Integer.parseInt(st.nextToken());
        }

        long[][][] dp = new long[N + 1][K + 1][901];

        for (int n = N; n > N - M; n--) {
            for (int k = 1; k <= K; k++) {
                for (int s = 1; s <= 900; s++) {
                    dp[n][k][s] = dp[n][k - 1][s];

                    if (D[n] * s >= P[k]) {
                        int d = (int) Math.ceil((double) P[k] / D[n]);
                        dp[n][k][s] = Math.max(dp[n][k][s], dp[n][k - 1][s - d] + Q[k]);
                    }
                }
                answer += dp[n][K][900];
            }
        }

        System.out.print(answer);
    }
}
