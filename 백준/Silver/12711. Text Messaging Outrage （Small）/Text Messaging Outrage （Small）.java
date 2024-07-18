import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int P, K, L;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			P = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			List<Integer> alphabetCount = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < L; i++) {
				alphabetCount.add(Integer.parseInt(st.nextToken()));
			}
			alphabetCount.sort(Comparator.reverseOrder());
			List<Integer> pressCount = new ArrayList<>();
			for (int i = 1; i <= P; i++) {
				for (int j = 1; j <= K; j++) {
					pressCount.add(i);
				}
			}
			int totalPressCount = IntStream.range(0, alphabetCount.size())
				.map(i -> alphabetCount.get(i) * pressCount.get(i))
				.sum();

			System.out.printf("Case #%d: %d\n", n, totalPressCount);
		}
	}
}