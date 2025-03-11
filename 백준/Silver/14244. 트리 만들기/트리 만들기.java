import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1; i < n; i++) {
            if (i < n - m) {
                System.out.printf("%d %d\n", i - 1, i);
            } else {
                System.out.printf("%d %d\n", n - m - 1, i);
            }
        }
    }
}
