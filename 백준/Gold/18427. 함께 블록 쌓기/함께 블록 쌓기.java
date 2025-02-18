import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] blocks = new int[N + 1][];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            blocks[i] = new int[st.countTokens()];
            for (int j = 0; j < blocks[i].length; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[H + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int[] nextDp = Arrays.copyOf(dp, dp.length);
            for (int block : blocks[i]) {
                for (int h = H; h >= block; h--) {
                    nextDp[h] = (nextDp[h] + dp[h - block]) % 10007;
                }
            }
            dp = nextDp;
        }

        System.out.print(dp[H]);
    }
}
