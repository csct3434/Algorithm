import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N+1], J = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= L[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - L[i]] + J[i]);
                }
            }
        }

        System.out.print(dp[N][99]);
    }
}
