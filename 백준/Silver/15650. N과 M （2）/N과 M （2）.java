import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(1, 0, new int[M]);
        System.out.print(answer);
    }

    private static void dfs(int number, int count, int[] numbers) {
        if (count == M) {
            for (int n : numbers) {
                answer.append(n).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int num = number; num <= N; num++) {
            numbers[count] = num;
            dfs(num + 1, count + 1, numbers);
        }
    }
}
