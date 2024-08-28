import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    private static final int UP = -1, DOWN = 1, RIGHT = 1, LEFT = -1;
    private static int cctvCount, N, M, answer = Integer.MAX_VALUE;
    private static List<int[]> cctvInfos;
    private static int[][] office;
    private static final int COVERED = 12345;
    private static final int[][][][] rangeInfo = {
            {},
            {{{0, RIGHT}}, {{DOWN, 0}}, {{0, LEFT}}, {{UP, 0}}},
            {{{0, RIGHT}, {0, LEFT}}, {{UP, 0}, {DOWN, 0}}},
            {{{UP, 0}, {0, RIGHT}}, {{0, RIGHT}, {DOWN, 0}}, {{DOWN, 0}, {0, LEFT}}, {{0, LEFT}, {UP, 0}}},
            {{{0, LEFT}, {UP, 0}, {0, RIGHT}}, {{UP, 0}, {0, RIGHT}, {DOWN, 0}}, {{0, RIGHT}, {DOWN, 0}, {0, LEFT}}, {{DOWN, 0}, {0, LEFT}, {UP, 0}}},
            {{{UP, 0}, {0, RIGHT}, {DOWN, 0}, {0, LEFT}}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctvInfos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] % 6 != 0) {
                    cctvCount++;
                    cctvInfos.add(new int[]{office[i][j], i, j});
                }
            }
        }
        dfs(0, new int[cctvCount]);
        System.out.println(answer);
    }

    private static void dfs(int depth, int[] rotationInfo) {
        if (depth == cctvCount) {
            int[][] markedOffice = markOfficeWithCoverage(rotationInfo);
            int blindSpotCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (markedOffice[i][j] == 0) blindSpotCount++;
                }
            }
            answer = Math.min(answer, blindSpotCount);
            return;
        }

        for (int i = 0; i < rangeInfo[cctvInfos.get(depth)[0]].length; i++) {
            rotationInfo[depth] = i;
            dfs(depth + 1, rotationInfo);
        }
    }

    private static int[][] markOfficeWithCoverage(int[] rotationInfo) {
        int[][] markedOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            markedOffice[i] = office[i].clone();
        }
        for (int i = 0; i < cctvCount; i++) {
            int[] cctvInfo = cctvInfos.get(i);
            int cctvType = cctvInfo[0];
            int x = cctvInfo[1];
            int y = cctvInfo[2];
            int[][] dxdys = rangeInfo[cctvType][rotationInfo[i]];
            for (int j = 0; j < dxdys.length; j++) {
                int dx = dxdys[j][0];
                int dy = dxdys[j][1];
                int nx = x, ny = y;
                while (true) {
                    nx += dx;
                    ny += dy;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || markedOffice[nx][ny] == 6) break;
                    markedOffice[nx][ny] = COVERED;
                }
            }
        }
        return markedOffice;
    }
}