import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

        return IntStream.rangeClosed(row_begin, row_end)
            .map(i -> Arrays.stream(data[i - 1]).map(x -> x % i).sum())
            .reduce(0, (a, b) -> a ^ b);
    }
}