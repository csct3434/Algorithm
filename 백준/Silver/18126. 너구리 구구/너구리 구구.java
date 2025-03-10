import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        long answer = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<long[]> queue = new LinkedList<>();

        visited[1] = true;
        queue.add(new long[]{1, 0});

        while (!queue.isEmpty()) {
            long[] item = queue.poll();
            int node = (int) item[0];
            long cost = item[1];
            answer = Math.max(answer, cost);
            for (int[] edge : graph.get(node)) {
                if (!visited[edge[0]]) {
                    visited[edge[0]] = true;
                    queue.add(new long[]{edge[0], cost + edge[1]});
                }
            }
        }

        System.out.print(answer);
    }
}
