import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        boolean[] digit = new boolean[10];
        for(int number : numbers) {
            digit[number] = true;
        }
        return (int) IntStream.range(0, 10).filter(i -> !digit[i]).sum();
    }
}