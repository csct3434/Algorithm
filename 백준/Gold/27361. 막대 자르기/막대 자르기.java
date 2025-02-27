import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] S = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                if (S[i] == 1) {
                    K--;
                }
            }

            long[] dp = new long[K + 1];
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < N; i++) {
                if (S[i] == 1) {
                    continue;
                }

                int L = S[i];
                long cost = (long) a * (L - 1) * (L - 1) + b;
                long[] temp = Arrays.copyOf(dp, dp.length);

                for (int j = 0; j <= K; j++) {
                    if (dp[j] != Long.MAX_VALUE) {
                        int targetIndex = Math.min(j + L, K);
                        temp[targetIndex] = Math.min(temp[targetIndex], dp[j] + cost);
                    }
                }

                dp = temp;
            }
            System.out.println(dp[K]);
        }
    }
}
