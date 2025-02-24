import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] L = new int[N + 1], C = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[X + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int c = 1; c <= C[i]; c++) {
                int l = L[i] * c;
                for (int x = X; x >= l; x--) {
                    temp[x] += dp[x - l];
                }
            }
            dp = temp;
        }

        System.out.print(dp[X]);
    }
}
