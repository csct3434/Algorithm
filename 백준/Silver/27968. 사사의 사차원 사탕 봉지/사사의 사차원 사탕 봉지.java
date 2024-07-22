import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] A = new long[M];
		st = new StringTokenizer(br.readLine(), " ");
		A[0] = Long.parseLong(st.nextToken());
		for (int i = 1; i < M; i++) {
			A[i] = A[i-1] + Long.parseLong(st.nextToken());
		}
		int idx;
		String overflow = "Go away!";
		while(N-- > 0) {
			idx = binarySearch(A, M, Long.parseLong(br.readLine()));
			System.out.println(idx == M ? overflow : idx + 1);
		}
	}

	private static int binarySearch(long[] A, int M, long value) {
		int left = 0, right = M-1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (A[mid] > value) right = mid - 1;
			else if(A[mid] < value) left = mid + 1;
			else return mid;
		}
		if (A[left] >= value) return left;
		return left + 1;
	}
}
