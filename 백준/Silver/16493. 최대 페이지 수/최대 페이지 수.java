import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] C = new int[M+1][2];
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            C[i][0] = Integer.parseInt(st.nextToken());
            C[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[M+1][N+1];
        for(int i=1; i<=M; i++) {
            for(int j=0; j<=N; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >= C[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - C[i][0]] + C[i][1]);
                }
            }
        }

        System.out.print(dp[M][N]);
    }
}