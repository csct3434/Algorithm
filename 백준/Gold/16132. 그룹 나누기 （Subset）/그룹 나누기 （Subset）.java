import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = (N * (N + 1)) / 2;

        if (S % 2 == 1) {
            System.out.println(0);
            return;
        }
        S /= 2;

        long[] dp = new long[S + 1];
        dp[0] = 1;

        for (int n = 1; n <= N; n++) {
            for (int s = S; s >= n; s--) {
                dp[s] += dp[s - n];
            }
        }

        System.out.println(dp[S] / 2);
    }
}
