import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static int[] values;
    private static int answer = -1;
    private static String[] words;
    private static char[] characters;
    private static Map<Character, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        words = new String[N];

        Set<Character> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
            for(char c : words[i].toCharArray()) set.add(c);
        }

        characters = new char[set.size()];
        values = new int[set.size()];
        int idx = 0;
        for(Character c : set) {
            characters[idx] = c;
            indexMap.put(c, idx++);
        }

        dfs(0, set.size(), new boolean[10]);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int total, boolean[] visited) {
        if(cnt == total) {
            int sum = 0;
            for(int i=0; i<words.length; i++) {
                sum += mapToValue(words[i]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<10; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            values[cnt] = i;
            dfs(cnt+1, total, visited);
            visited[i] = false;
        }
    }

    private static int mapToValue(String word) {
        int value = 0, base = (int) Math.pow(10, word.length() - 1);
        char[] c = word.toCharArray();
        for(int i=0; i<c.length; i++) {
            value += values[indexMap.get(c[i])] * base;
            base /= 10;
        }
        return value;
    }
}