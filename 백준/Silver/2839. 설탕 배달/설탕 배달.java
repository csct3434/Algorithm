import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt(), INF = 987654321;
        int[] dp = new int[Math.max(6, N + 1)];
        Arrays.fill(dp, INF);
        dp[3] = dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        System.out.print(dp[N] >= INF ? -1 : dp[N]);
    }
}
