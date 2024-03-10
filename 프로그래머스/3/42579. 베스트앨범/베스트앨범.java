import java.util.*;
import java.util.Map.*;
import java.util.stream.Collectors;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<int[]>> category = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!category.containsKey(genre)) {
                category.put(genre, new LinkedList<>());
            }
            category.get(genre).add(new int[]{i, plays[i]});
            count.put(genre, count.getOrDefault(genre, 0) + plays[i]);
        }

        List<Entry<String, Integer>> countEntries = new LinkedList<>(count.entrySet());
        countEntries.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> answer = new LinkedList<>();
        for (Entry<String, Integer> entry : countEntries) {
            List<int[]> list = category.get(entry.getKey());
            list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            answer.addAll(list.stream().limit(2).map(x -> x[0]).collect(Collectors.toList()));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}