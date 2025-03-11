import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> childNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            childNodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            childNodes.get(p).add(c);
        }

        boolean[] hasApple = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hasApple[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int node = item[0];
            int distance = item[1];

            if (hasApple[node]) {
                answer++;
            }

            for(int childNode : childNodes.get(node)) {
                if (distance < k) {
                    queue.add(new int[]{childNode, distance + 1});
                }
            }
        }

        System.out.print(answer);
    }
}
