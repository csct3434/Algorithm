import java.util.HashSet;

class Solution {

    public int solution(int[] elements) {
        int total = elements.length;
        HashSet<Integer> sequenceSum = new HashSet<>();

        int[] dp = new int[total + 1];
        for (int idx = 0; idx < total; idx++) {
            for (int length = 1; length <= total; length++) {
                dp[length] = dp[length - 1] + elements[(idx + length - 1) % total];
                sequenceSum.add(dp[length]);
            }
        }

        return sequenceSum.size();
    }
}
