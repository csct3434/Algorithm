import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()), answer;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken()) / 4;
            int K = Integer.parseInt(st.nextToken());
            StringBuilder number = new StringBuilder(br.readLine());
            Set<Integer> numbers = new HashSet<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                    numbers.add(Integer.parseInt(number.substring(len * j, len * (j + 1)), 16));
                }
                number.insert(0, number.charAt(number.length() - 1)).deleteCharAt(number.length() - 1);
            }
            answer = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(K - 1);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
