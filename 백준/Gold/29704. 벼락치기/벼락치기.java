import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] d = new int[N + 1];
        int[] m = new int[N + 1];

        int totalM = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
            totalM += m[i];
        }

        int[][] dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= d[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - d[i]] + m[i]);
                }
            }
        }

        System.out.print(totalM - dp[N][T]);
    }
}
