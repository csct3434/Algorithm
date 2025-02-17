import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] I = new int[K+1], T = new int[K+1];

        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            I[i] = Integer.parseInt(st.nextToken());
            T[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K+1][N+1];

        for(int i=1; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= T[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-T[i]] + I[i]);
                }
            }
        }

        System.out.print(dp[K][N]);
    }
}
