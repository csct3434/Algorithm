import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int N, K;
    private static int[][] plain;
    private static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            plain = new int[N][N];
            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maxHeight = Math.max(maxHeight, plain[i][j] = Integer.parseInt(st.nextToken()));
                }
            }
            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (plain[i][j] != maxHeight) continue;
                    answer = Math.max(answer, dfs(i, j, true, new boolean[N][N]));
                }
            }
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static int dfs(int x, int y, boolean canDig, boolean[][] visited) {
        visited[x][y] = true;
        int maxLength = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
            if (plain[nx][ny] < plain[x][y]) {
                maxLength = Math.max(maxLength, dfs(nx, ny, canDig, visited) + 1);
            } else if (canDig && plain[nx][ny] - plain[x][y] < K) {
                int temp = plain[nx][ny];
                plain[nx][ny] = plain[x][y] - 1;
                maxLength = Math.max(maxLength, dfs(nx, ny, false, visited) + 1);
                plain[nx][ny] = temp;
            }
        }
        visited[x][y] = false;
        return maxLength;
    }
}
