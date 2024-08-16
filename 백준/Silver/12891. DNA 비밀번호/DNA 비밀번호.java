import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        Map<Character, Integer> requires = new HashMap<>(), count = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (char c : "ACGT".toCharArray()) {
            requires.put(c, Integer.parseInt(st.nextToken()));
            count.put(c, 0);
        }
        for (int i = 0; i < P; i++) {
            count.put(dna.charAt(i), count.get(dna.charAt(i)) + 1);
        }
        int answer = checkCondition(count, requires) ? 1 : 0;
        char oldC, newC;
        for (int i = P; i < S; i++) {
            oldC = dna.charAt(i - P);
            newC = dna.charAt(i);
            count.put(oldC, count.get(oldC) - 1);
            count.put(newC, count.get(newC) + 1);
            if (checkCondition(count, requires)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean checkCondition(Map<Character, Integer> count, Map<Character, Integer> requires) {
        for (char c : "ACGT".toCharArray()) {
            if (count.get(c) < requires.get(c)) return false;
        }
        return true;
    }
}
