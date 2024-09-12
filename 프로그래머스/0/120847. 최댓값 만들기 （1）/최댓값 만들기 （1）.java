import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        return Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).limit(2).reduce((a, b) -> a * b).orElse(1);
    }
}