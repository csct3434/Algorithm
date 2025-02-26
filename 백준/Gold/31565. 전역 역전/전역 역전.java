import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int daysDiff = calcDaysDiff(br.readLine(), br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] plans = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int delay = command == 3 ? M * 30 : M;
            plans[i][0] = C;
            plans[i][1] = delay;
        }

        int[] dp = new int[T + 1];

        for (int[] plan : plans) {
            int C = plan[0];
            int delay = plan[1];
            for (int t = 0; t + C <= T; t++) {
                dp[t] = Math.max(dp[t], dp[t + C] + delay);
            }
        }

        int maxDelay = Arrays.stream(dp).max().orElse(0);
        System.out.print(Math.abs(daysDiff - maxDelay));
    }

    private static int calcDaysDiff(String jh, String yd) {
        String[] tokens = jh.split(" ");
        LocalDate jhDate = LocalDate.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        tokens = yd.split(" ");
        LocalDate ydDate = LocalDate.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        return (int) ChronoUnit.DAYS.between(jhDate, ydDate);
    }
}
