import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] majorityVote = new int[2];
		int[] electoralVote = new int[2];
		int e, v0, v1;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			e = Integer.parseInt(st.nextToken());
			v0 = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			majorityVote[0] += v0;
			majorityVote[1] += v1;
			if (v0 > v1) electoralVote[0] += e;
			if (v1 > v0) electoralVote[1] += e;
		}
		System.out.println(majorityVote[0] > majorityVote[1] && electoralVote[0] > electoralVote[1] ? 1
			: majorityVote[0] < majorityVote[1] && electoralVote[0] < electoralVote[1] ? 2 : 0);
	}
}