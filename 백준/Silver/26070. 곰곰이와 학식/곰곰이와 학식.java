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
            int m = Math.min(people[i], ticket[i]);
            people[i] -= m;
            ticket[i] -= m;
        }
        for (int i = 0; i < 3; i++) {
            if (people[i] == 0 && people[(i + 4) % 3] > 0) {
                int m = Math.min(people[(i + 4) % 3], ticket[i] / 3);
                people[(i + 4) % 3] -= m;
                ticket[i] -= m * 3;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (people[i] == 0 && people[(i + 5) % 3] > 0) {
                int m = Math.min(people[(i + 5) % 3], ticket[i] / 9);
                people[(i + 5) % 3] -= m;
                ticket[i] -= m * 9;
            }
        }
        System.out.println(IntStream.range(0, 3).mapToLong(i -> total[i] - people[i]).sum());
    }
}
