import java.util.Scanner;

public class Main {

    private static int N;
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        for (int startNumber : new int[]{2, 3, 5, 7}) {
            dfs(1, startNumber);
        }
        System.out.println(answer);
    }

    private static void dfs(int depth, int num) {
        if (depth == N) {
            answer.append(num).append("\n");
            return;
        }
        int nextNumber;
        for (int digit = 0; digit <= 9; digit++) {
            if (isPrime(nextNumber = num * 10 + digit)) {
                dfs(depth + 1, nextNumber);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
