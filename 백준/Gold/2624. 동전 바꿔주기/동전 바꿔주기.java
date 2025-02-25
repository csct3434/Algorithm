import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] P = new int[K], N = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            N[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[T + 1];
        dp[0] = 1;

        for (int i = 0; i < K; i++) {
            int p = P[i], n = N[i];
            int[] temp = Arrays.copyOf(dp, dp.length);

            for (int j = 1; j <= n; j++) {
                int amount = p * j;
                for (int k = amount; k <= T; k++) {
                    temp[k] += dp[k - amount];
                }
            }

            dp = temp;
        }

        System.out.print(dp[T]);
    }
}
