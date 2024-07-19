import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static int P, Q;

	private static final Map<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();
		if (P > Q) {
			int temp = P;
			P = Q;
			Q = temp;
		}
		System.out.println(getValue(N));
	}

	private static long getValue(long num) {
		if (num == 0) {
			return 1;
		}
		if (dp.containsKey(num)) {
			return dp.get(num);
		}
		long result = getValue(num / P) + getValue(num / Q);
		dp.put(num, result);
		return result;
	}
}