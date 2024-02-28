import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Long> countBySize = Arrays.stream(tangerine).boxed()
            .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

        List<Long> counts = countBySize.values()
            .stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

        for (Long count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}