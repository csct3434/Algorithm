import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a, b) -> a[0] - b[0]);
        return Math.abs(dots[0][0] - dots[2][0]) * Math.abs(dots[0][1] - dots[1][1]);
    }
}