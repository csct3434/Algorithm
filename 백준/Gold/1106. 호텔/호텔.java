import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] info = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 현재 도시 i번
        for (int i = 1; i <= N; i++) {
            int cost = info[i][0];
            int capacity = info[i][1];

            // 목표 인구 j명
            for (int j = capacity; j < C + capacity; j++) {
                // 불가능한 경우가 아니라면
                if (dp[j - capacity] != Integer.MAX_VALUE) {
                    if(j > C) {
                        dp[C] = Math.min(dp[C], dp[j - capacity] + cost);
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - capacity] + cost);
                    }
                }
            }
        }

        System.out.print(dp[C]);
    }
}
