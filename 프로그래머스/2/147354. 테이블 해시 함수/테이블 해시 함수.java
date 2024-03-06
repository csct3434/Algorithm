import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[][] data, int _col, int row_begin, int row_end) {
        final int col = _col - 1;

        Arrays.sort(data, (a, b) -> {
            if (a[col] == b[col]) {
                return b[0] - a[0];
            }
            return a[col] - b[col];
        });

        return IntStream.rangeClosed(row_begin, row_end)
            .map(i -> {
                final int fi = i;
                return Arrays.stream(data[i - 1]).map(x -> x % fi).sum();
            })
            .reduce(0, (a, b) -> a ^ b);
    }
}