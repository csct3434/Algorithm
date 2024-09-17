import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist).boxed().sorted((a, b) -> {
            if(Math.abs(a - n) == Math.abs(b - n)) return b - a;
            return Math.abs(a - n) - Math.abs(b - n);
        }).mapToInt(i->i).toArray();
    }
}