import java.util.*;
import java.util.Map.*;

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
            for (int i = 0; i < Math.min(list.size(), 2); i++) {
                answer.add(list.get(i)[0]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}