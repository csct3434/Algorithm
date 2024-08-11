import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int N;
    private static int[] num = {50, 10, 5, 1};
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, N, 0);
        System.out.println(set.size());
    }

    private static void dfs(int idx, int remains, int value) {
        if (remains == 0) {
            set.add(value);
            return;
        }
        if(idx == 3) {
            set.add(value + num[idx] * remains);
            return;
        }
        for (int count = 0; count <= remains; count++) {
            dfs(idx + 1, remains - count, value + num[idx] * count);
        }
    }
}
