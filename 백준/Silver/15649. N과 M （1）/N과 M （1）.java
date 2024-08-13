import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(new ArrayList<>(), new boolean[N+1]);
        System.out.println(sb.toString());
    }

    private static void dfs(List<Integer> numbers, boolean[] visited) {
        if (numbers.size() == M) {
            for (Integer number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int num = 1; num <= N; num++) {
            if (visited[num]) continue;
            visited[num] = true;
            numbers.add(num);
            dfs(numbers, visited);
            numbers.remove(numbers.size() - 1);
            visited[num] = false;
        }
    }
}
