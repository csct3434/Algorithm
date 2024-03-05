import java.util.HashSet;

class Solution {

    public int solution(int[] elements) {
        int total = elements.length;
        HashSet<Integer> sequenceSum = new HashSet<>();

        int[] sum = new int[total];
        sum[0] = elements[0];
        for (int i = 1; i < total; i++) {
            sum[i] = sum[i - 1] + elements[i];
        }

        for (int length = 1; length <= total; length++) {
            for (int start = 0; start < total; start++) {
                sequenceSum.add(calcSequenceSum(elements, total, sum, start, length));
            }
        }

        return sequenceSum.size();
    }

    private int calcSequenceSum(int[] elements, int total, int[] sum, int start, int length) {
        int end = (start + length - 1) % total;

        if (start == end) {
            return elements[start];
        } else if (start < end) {
            return sum[end] - sum[start] + elements[start];
        } else {
            return sum[end] + (sum[total - 1] - sum[start - 1]);
        }
    }
}
