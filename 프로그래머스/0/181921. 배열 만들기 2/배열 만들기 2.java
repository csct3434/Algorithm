import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] ans = IntStream.rangeClosed(l, r).filter(n -> String.valueOf(n).replaceAll("[05]", "").length() == 0).toArray();
        return ans.length == 0 ? new int[]{-1} : ans;
    }
}