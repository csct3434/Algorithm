import java.util.*;

public class Main {

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(arr, new boolean[N], new ArrayList<>());
        System.out.println(answer);
    }

    private static void dfs(int[] arr, boolean[] visited, List<Integer> result) {
        if (result.size() == arr.length) {
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                sum += Math.abs(arr[result.get(i)] - arr[result.get(i-1)]);
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result.add(i);
            dfs(arr, visited, result);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}
