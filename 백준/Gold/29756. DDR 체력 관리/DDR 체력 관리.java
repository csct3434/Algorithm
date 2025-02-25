import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N], H = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for (int i = 0; i < N; i++) {
            int score = S[i], hp = H[i];

            for (int h = 0; h + hp <= 100; h++) {
                dp[h] = Math.max(dp[h], dp[h + hp] + score);
            }
            
            int[] temp = new int[101];
            for(int h = 0; h <= 100; h++) {
                if(h + K >= 100) {
                    temp[100] = Math.max(temp[100], dp[h]);
                } else {
                    temp[h + K] = dp[h];
                }
            }
            dp = temp;
        }

        int answer = 0;
        for(int h=0; h<=100; h++) {
            answer = Math.max(answer, dp[h]);
        }
        System.out.print(answer);
    }
}