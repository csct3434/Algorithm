import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {

    public int[] solution(String s) {
        int[] answer;
        int count = 0;

        String[] subsets = s.replaceAll("},", "} ").substring(1, s.length() - 1).split(" ");
        Arrays.sort(subsets, Comparator.comparingInt(String::length));

        answer = new int[subsets.length];
        HashSet<String> used = new HashSet<>();

        for (String subset : subsets) {
            String nextNumber = Arrays.stream(subset.substring(1, subset.length() - 1).split(","))
                .filter(number -> !used.contains(number))
                .findFirst()
                .orElse("0");

            used.add(nextNumber);
            answer[count++] = Integer.parseInt(nextNumber);
        }

        return answer;
    }
}