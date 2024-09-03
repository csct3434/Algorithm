import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static int N, M, globalMaxCount;
    private static int[][] plain, visited;
    private static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            plain = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    plain[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            globalMaxCount = 0;
            dfs(1);
            sb.append('#').append(tc).append(' ').append(globalMaxCount).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int k) {
        if (k > N + 1) return;
        int serviceCost = k * k + (k - 1) * (k - 1);
        int maxCount = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int mask = k * 10000 + x * 100 + y;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{x, y});
                visited[x][y] = mask;
                int count = 0;
                while (!queue.isEmpty()) {
                    int[] info = queue.remove();
                    int cx = info[0];
                    int cy = info[1];
                    if (plain[cx][cy] == 1) count++;
                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] != mask && Math.abs(x - nx) + Math.abs(y - ny) < k) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = mask;
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        if (maxCount * M >= serviceCost && maxCount > globalMaxCount) {
            globalMaxCount = maxCount;
        }
        dfs(k + 1);
    }
}
