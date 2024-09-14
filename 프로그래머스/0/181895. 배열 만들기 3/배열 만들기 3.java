import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return IntStream.range(0, intervals.length).flatMap(i -> Arrays.stream(Arrays.copyOfRange(arr, intervals[i][0], intervals[i][1] + 1))).toArray();
    }
}