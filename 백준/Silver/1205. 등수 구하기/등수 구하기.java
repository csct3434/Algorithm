import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(
			st.nextToken());
		int[] scores = new int[N];
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
		}
		int rank = N < P ? N + 1 : -1;
		for (int i = 0; i < N; i++) {
			if (scores[i] <= S) {
				int count = 0, idx = i;
                rank = i + 1;
				while (idx < N && scores[idx++] == S) {
					count++;
				}
				int maxRank = rank + count;
				if (maxRank > P)
					rank = -1;
				break;
			}
		}
		System.out.println(rank);
	}
}