import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 알고리즘
public class Main {

    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), K = Integer.parseInt(br.readLine());
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (!edges.containsKey(v1)) edges.put(v1, new ArrayList<>());
            edges.get(v1).add(new int[]{v2, w});
        }
        int[] dp = new int[V + 1];
        Arrays.fill(dp, INF);
        dp[K] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] info = pq.remove();
            int curNode = info[0];
            int curCost = info[1];
            if (curCost > dp[curNode] || !edges.containsKey(curNode)) continue;
            for (int[] edge : edges.get(curNode)) {
                int nextNode = edge[0];
                int nextCost = edge[1];
                if (curCost + nextCost < dp[nextNode]) {
                    dp[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, dp[nextNode]});
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            answer.append(dp[i] == INF ? "INF" : dp[i]).append('\n');
        }
        System.out.print(answer);
    }
}