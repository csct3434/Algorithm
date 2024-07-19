import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(), a = 0, b = 1, temp;
		if (n < 2) {
			System.out.println(n);
			return;
		}
		while (--n > 0) {
			temp = a;
			a = b;
			b = (b + temp) % 1000000007;
		}
		System.out.println(b);
	}
}