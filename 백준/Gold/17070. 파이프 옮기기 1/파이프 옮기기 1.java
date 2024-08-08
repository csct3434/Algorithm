import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[N][N][3];
        for (int i = 1; i < N; i++) {
            if (board[0][i] == 1) break;
            dp[0][i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                if (board[i-1][j] == 0 && board[i][j-1] == 0) dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        int answer = 0;
        for (int i=0; i<3; i++) {
            answer += dp[N-1][N-1][i];
        }
        System.out.println(answer);
    }
}
