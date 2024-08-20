import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startIdx = 0, height = N, width = M;
        while (height > 1 && width > 1) {
            rotate(arr, startIdx++, width, height, R % ((height + width) * 2 - 4));
            height -= 2;
            width -= 2;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer.append(arr[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void rotate(int[][] arr, int startIdx, int width, int height, int count) {
        for (int i = 0; i < count; i++) {
            int x = startIdx, y = startIdx, toss = arr[startIdx][startIdx], temp;
            while (x < startIdx + height - 1) {
                temp = arr[++x][y];
                arr[x][y] = toss;
                toss = temp;
            }
            while (y < startIdx + width - 1) {
                temp = arr[x][++y];
                arr[x][y] = toss;
                toss = temp;
            }
            while (x > startIdx) {
                temp = arr[--x][y];
                arr[x][y] = toss;
                toss = temp;
            }
            while (y > startIdx) {
                temp = arr[x][--y];
                arr[x][y] = toss;
                toss = temp;
            }
        }
    }
}
