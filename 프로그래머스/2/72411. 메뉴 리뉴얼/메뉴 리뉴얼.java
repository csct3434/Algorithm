import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> combinations = new HashMap<>();

        for (String order : orders) {
            for (int mask = 1; mask < (1 << order.length()); mask++) {
                int finalMask = mask;
                if (Arrays.stream(course).noneMatch(c -> Integer.bitCount(finalMask) == c)) {
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < order.length(); i++) {
                    if ((mask & (1 << i)) != 0) {
                        sb.append(order.charAt(i));
                    }
                }

                char[] foods = sb.toString().toCharArray();
                Arrays.sort(foods);
                String combination = new String(foods);
                combinations.put(combination, combinations.getOrDefault(combination, 0) + 1);
            }
        }

        HashMap<Integer, Integer> maxCount = new HashMap<>();
        for (String combination : combinations.keySet()) {
            int length = combination.length();
            int count = combinations.get(combination);

            maxCount.put(length, Math.max(maxCount.getOrDefault(length, 0), count));
        }

        List<String> answer = new LinkedList<>();
        for (Entry<String, Integer> entry : combinations.entrySet()) {
            String combination = entry.getKey();
            int count = entry.getValue();

            if (count > 1 && maxCount.get(combination.length()) == count) {
                answer.add(combination);
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}