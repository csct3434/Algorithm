import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Integer> countPerWeight = new HashMap<>();
        HashMap<Integer, List<Integer>> torqueMap = new HashMap<>();

        for (int k : weights) {
            countPerWeight.put(k, countPerWeight.getOrDefault(k, 0) + 1);
        }
        answer += countPerWeight.values().stream().mapToLong(x -> (long) x * (x - 1) / 2).sum();

        for (int weight : countPerWeight.keySet()) {
            for (int distance = 2; distance <= 4; distance++) {
                int torque = weight * distance;
                if (!torqueMap.containsKey(torque)) {
                    torqueMap.put(torque, new LinkedList<>());
                }
                torqueMap.get(torque).add(weight);
            }
        }

        for (int torque : torqueMap.keySet()) {
            List<Integer> weight = torqueMap.get(torque);
            for (int i = 0; i < weight.size(); i++) {
                for (int j = i + 1; j < weight.size(); j++) {
                    answer += (long) countPerWeight.get(weight.get(i)) * countPerWeight.get(weight.get(j));
                }
            }
        }

        return answer;
    }
}