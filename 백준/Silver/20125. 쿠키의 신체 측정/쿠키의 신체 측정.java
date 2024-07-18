import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        int heartX = 0, heartY = 0;
        boolean isHeadFound = false;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) == '_' ? 0 : 1;
                if (!isHeadFound && arr[i][j] == 1) {
                    heartX = i + 1;
                    heartY = j;
                    isHeadFound = true;
                }
            }
        }

        int backX = heartX, backY = heartY;
        for (int x = heartX + 1; x < N; x++) {
            if (arr[x][backY] == 1) {
                backX++;
            } else {
                break;
            }
        }

        int leftArmLength = 0, rightArmLength = 0, leftLegLength = 0, rightLegLength = 0;

        for (int y = heartY - 1; y >= 0; y--) {
            if (arr[heartX][y] == 1) {
                leftArmLength++;
            } else {
                break;
            }
        }
        for (int y = heartY + 1; y < N; y++) {
            if (arr[heartX][y] == 1) {
                rightArmLength++;
            } else {
                break;
            }
        }

        for (int x = backX + 1; x < N; x++) {
            if (arr[x][backY - 1] == 1) {
                leftLegLength++;
            } else {
                break;
            }
        }
        for (int x = backX + 1; x < N; x++) {
            if (arr[x][backY + 1] == 1) {
                rightLegLength++;
            } else {
                break;
            }
        }
        System.out.printf("%d %d\n", heartX + 1, heartY + 1);
        System.out.printf("%d %d %d %d %d", leftArmLength, rightArmLength, backX - heartX, leftLegLength,
            rightLegLength);
    }
}