import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] C = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= C[i]; j--) {
                if (dp[j - C[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - C[i]] + 1);
                }
            }
        }

        System.out.print(dp[K] != Integer.MAX_VALUE ? dp[K] : -1);
    }
}
