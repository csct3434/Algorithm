import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] X = new int[N + 1], Y = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[M + 1][K + 1];

        for (int n = 1; n <= N; n++) {
            int x = X[n], y = Y[n];

            for(int m = M; m >= x; m--) {
                for(int k = K; k >= y; k--) {
                    dp[m][k] = Math.max(dp[m][k], dp[m - x][k - y] + 1);
                }
            }
        }

        System.out.print(dp[M][K]);
    }
}
