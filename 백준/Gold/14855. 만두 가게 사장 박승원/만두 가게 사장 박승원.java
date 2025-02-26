import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int c0 = Integer.parseInt(st.nextToken());
        int d0 = Integer.parseInt(st.nextToken());

        int[][] items = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[N + 1];
        for (int count = 1; count <= N / c0; count++) {
            dp[N - count * c0] = count * d0;
        }

        for (int[] item : items) {
            int maxCount = item[0] / item[1];
            int c = item[2];
            int d = item[3];

            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int count = 1; count <= maxCount; count++) {
                int C = c * count;
                int D = d * count;

                for (int n = 0; n + C <= N; n++) {
                    temp[n] = Math.max(temp[n], dp[n + C] + D);
                }
            }
            dp = temp;
        }

        System.out.print(Arrays.stream(dp).max().orElse(0));
    }
}
