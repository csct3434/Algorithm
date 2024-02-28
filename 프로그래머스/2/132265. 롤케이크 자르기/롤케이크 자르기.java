import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;

        Map<Integer, Long> partA = Arrays.stream(toppings).boxed()
            .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        
        HashSet<Object> partB = new HashSet<>();

        for (int topping : toppings) {
            partA.put(topping, partA.get(topping) - 1);
            partB.add(topping);

            if (partA.get(topping) == 0) {
                partA.remove(topping);
            }
            
            if (partA.keySet().size() == partB.size()) {
                answer++;
            }
        }

        return answer;
    }
}