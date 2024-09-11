import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        int a = Arrays.stream(numbers).sum();
        return (double) a / numbers.length;
    }
}