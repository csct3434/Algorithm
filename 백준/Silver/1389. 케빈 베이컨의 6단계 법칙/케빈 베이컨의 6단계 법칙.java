import java.util.*;

public class Main {

    private static int N, M;
    private static Map<Integer, List<Integer>> adjacentList = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            adjacentList.put(i, new ArrayList<>());
        }
        int A, B;
        for (int i = 0; i < M; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            adjacentList.get(A).add(B);
            adjacentList.get(B).add(A);
        }
        int minKc = Integer.MAX_VALUE, answer = 1;
        for (int i = 1; i <= N; i++) {
            int kc = 0;
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            queue.add(new int[]{i, 0});
            visited[i] = true;
            while (!queue.isEmpty()) {
                int[] info = queue.remove();
                int curNode = info[0], depth = info[1];
                kc += depth;
                for (Integer adjacentNode : adjacentList.get(curNode)) {
                    if (visited[adjacentNode]) continue;
                    queue.add(new int[]{adjacentNode, depth + 1});
                    visited[adjacentNode] = true;
                }
            }
            if (kc < minKc) {
                answer = i;
                minKc = kc;
            }
        }
        System.out.println(answer);
    }
}
