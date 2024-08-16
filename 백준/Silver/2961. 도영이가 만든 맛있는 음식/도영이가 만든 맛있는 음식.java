import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] S = new int[N], B = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        long minDiff = Long.MAX_VALUE;
        for (int mask = 1; mask < Math.pow(2, N); mask++) {
            long productOfS = 1, sumOfB = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) > 0) {
                    productOfS *= S[i];
                    sumOfB += B[i];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(productOfS - sumOfB));
        }
        System.out.println(minDiff);
    }
}
