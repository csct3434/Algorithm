import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken().replace(".", ""));

            if (n == 0 && m == 0) {
                break;
            }

            int[] c = new int[n + 1];
            int[] p = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                c[i] = Integer.parseInt(st.nextToken());
                p[i] = Integer.parseInt(st.nextToken().replace(".", ""));
            }

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= p[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - p[i]] + c[i]);
                    }
                }
            }

            answer.append(dp[n][m]).append('\n');
        }

        System.out.print(answer);
    }
}
