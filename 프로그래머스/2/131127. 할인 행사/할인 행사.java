import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantsCount = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantsCount.put(want[i], number[i]);
        }

        HashMap<String, Integer> discountsCount = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Integer count = discountsCount.getOrDefault(discount[i], 0);
            discountsCount.put(discount[i], count + 1);
        }

        for (int i = 0; i + 10 <= discount.length; i++) {
            boolean impossible = wantsCount.keySet()
                .stream()
                .anyMatch(item -> wantsCount.get(item) > discountsCount.getOrDefault(item, 0));

            if (!impossible) {
                answer++;
            }
            
            if (i + 10 < discount.length) {
                Integer oldestItemCount = discountsCount.get(discount[i]);
                discountsCount.put(discount[i], oldestItemCount - 1);

                Integer nextItemCount = discountsCount.getOrDefault(discount[i + 10], 0);
                discountsCount.put(discount[i + 10], nextItemCount + 1);
            }
        }

        return answer;
    }
}