import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M+1];
            dp[0] = 1;

            Set<Integer> usedNumbers = new HashSet<>();

            for(int i=1; i<=N; i++) {
                if(usedNumbers.contains(coins[i])) continue;
                usedNumbers.add(coins[i]);
                for(int j=coins[i]; j<=M; j++) {
                    dp[j] += dp[j-coins[i]];
                }
            }

            answer.append(dp[M]).append('\n');
        }
        System.out.print(answer);
    }
}
