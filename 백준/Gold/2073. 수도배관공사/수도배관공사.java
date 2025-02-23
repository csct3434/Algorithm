import java.io.*;
import java.util.*;

public class Main {
    private static final int UNREACHABLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] L = new int[P];
        int[] C = new int[P];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, UNREACHABLE);
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            int length = L[i], capacity = C[i];
            for (int j = D; j >= length; j--) {
                if (dp[j - length] != UNREACHABLE) {
                    dp[j] = Math.max(dp[j], Math.min(dp[j - length], capacity));
                }
            }
        }

        System.out.println(dp[D]);
    }
}