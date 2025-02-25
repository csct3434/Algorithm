import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int n = 1; n <= M; n++) {
            int S = 0, N = n;
            while(N > 0) {
                S += N % 10;
                N /= 10;
            }
            if (n % S == 0) {
                list.add(n);
            }
        }

        int[] dp = new int[M + 1];
        dp[0] = 1;

        for(int p : list) {
            for(int n=p; n<=M; n++) {
                dp[n] = (dp[n] + dp[n-p]) % K;
            }
        }

        System.out.print(dp[M]);
    }
}
