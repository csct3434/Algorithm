import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 크루스칼 알고리즘
public class Main {

    private static final int[] parent = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Arrays.fill(parent, -1);
        int answer = 0;
        while (-parent[find(1)] != V) {
            int[] info = pq.remove();
            if (!union(info[0], info[1])) continue;
            answer += info[2];
        }
        System.out.print(answer);
    }

    private static int find(int v) {
        if (parent[v] < 0) return v;
        return parent[v] = find(parent[v]);
    }

    private static boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return false;
        if (parent[p1] < parent[p2]) {
            parent[p1] += parent[p2];
            parent[p2] = p1;
        } else {
            parent[p2] += parent[p1];
            parent[p1] = p2;
        }
        return true;
    }
}