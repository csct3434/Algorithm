import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][T+1];
        int[][] info = new int[N+1][2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=T; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= info[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-info[i][0]] + info[i][1]);
                }
            }
        }

        System.out.print(dp[N][T]);
    }
}
