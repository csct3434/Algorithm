import java.io.IOException;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        int T = sc.nextInt();
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int idx = 0, number = 1, lastNumber = N * N, x = 0, y = -1, nx, ny;
            while (number <= lastNumber) {
                while (true) {
                    nx = x + dx[idx % 4];
                    ny = y + dy[idx % 4];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) break;
                    x = nx;
                    y = ny;
                    arr[x][y] = number++;
                }
                idx++;
            }
            answer.append("#").append(tc).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer.append(arr[i][j]).append(" ");
                }
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }
}