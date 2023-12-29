import java.util.Arrays;

class Solution {

    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .reduce("", (a, b) -> a + b);

        return answer.equals("0".repeat(answer.length())) ? "0" : answer;
    }
}