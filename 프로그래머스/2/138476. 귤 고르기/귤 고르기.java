import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countBySize = getCountBySize(tangerine);

        List<Integer> counts = countBySize.values()
            .stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

        for (Integer count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }

    Map<Integer, Integer> getCountBySize(int[] tangerineSize) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int t : tangerineSize) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }

        return count;
    }
}