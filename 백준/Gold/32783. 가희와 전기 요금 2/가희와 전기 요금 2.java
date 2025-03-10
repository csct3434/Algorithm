import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] usage = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            usage[i][0] = Integer.parseInt(st.nextToken());
            usage[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[] dp = new int[c2 + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int a = usage[i][0];
            int m = usage[i][1];
            long _cost = (long) a * m * 96 / 1000 / 60;

            if (_cost > c2) {
                continue;
            }

            int cost = (int) _cost;
            for (int j = c2; j >= cost; j--) {
                dp[j] = (dp[j] + dp[j - cost]) % 1000000007;
            }
        }

        int answer = 0;
        for (int i = c1; i <= c2; i++) {
            answer = (answer + dp[i]) % 1000000007;
        }

        System.out.print(answer);
    }
}
