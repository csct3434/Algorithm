import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        return (int) IntStream.rangeClosed(left, right)
            .map(n -> Math.sqrt(n) % 1 == 0 ? -n : n)
            .sum();
    }
}