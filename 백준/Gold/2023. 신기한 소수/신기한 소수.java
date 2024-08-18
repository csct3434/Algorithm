import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        int N = new Scanner(System.in).nextInt();
        for (int n : new int[]{2, 3, 5, 7}) {
            int start = n * (int) Math.pow(10, N-1);
            int end = (n+1) * (int) Math.pow(10, N-1);
            for (int num = start; num < end; num++) {
                int d = (int) Math.pow(10, N - 1);
                boolean prime = true;
                while (d > 0) {
                    if (!isPrime(num / d)) {
                        prime = false;
                        break;
                    }
                    d /= 10;
                }
                if (prime) answer.append(num).append("\n");
            }
        }
        System.out.print(answer);
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
