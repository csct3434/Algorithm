import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] people = new int[3], total = new int[3], ticket = new int[3];
        for (int i = 0; i < 3; i++) {
            total[i] = people[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            ticket[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int pIdx = (j + 3 + i) % 3, weight = (int) Math.pow(3, i);
                int m = Math.min(people[pIdx], ticket[j] / weight);
                people[pIdx] -= m;
                ticket[j] -= m * weight;
            }
        }
        System.out.println(IntStream.range(0, 3).mapToLong(i -> total[i] - people[i]).sum());
    }
}
