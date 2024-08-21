import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long answer = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int N = Integer.parseInt(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        dfs(0, 0, r, c, (long) Math.pow(2, N), 0);
        System.out.println(answer);
    }

    private static void dfs(long x, long y, long r, long c, long length, long base) {
        if (length == 2) {
            answer = base;
            if (x < r) answer += 2;
            if (y < c) answer += 1;
            return;
        }
        length /= 2;
        long[] dx = new long[]{0, 0, length, length};
        long[] dy = new long[]{0, length, 0, length};
        for (int i = 0; i < 4; i++) {
            long nx = x + dx[i];
            long ny = y + dy[i];
            if (nx <= r && r < nx + length && ny <= c && c < ny + length) {
                dfs(nx, ny, r, c, length, base + length * length * i);
                break;
            }
        }
    }
}
