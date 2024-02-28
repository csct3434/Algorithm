import java.util.LinkedList;
import java.util.List;

class Solution {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> sequences = calcSequences(k);

        for (int i = 0; i < ranges.length; i++) {
            answer[i] = getArea(sequences, ranges[i]);
        }
        return answer;
    }

    private List<Integer> calcSequences(int k) {
        LinkedList<Integer> sequences = new LinkedList<>();

        while (k != 1) {
            sequences.add(k);

            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }

        sequences.add(1);
        return sequences;
    }

    private double getArea(List<Integer> sequences, int[] range) {
        int n = sequences.size() - 1;

        int xA = range[0];
        int xB = n + range[1];

        if (xA > xB) {
            return -1;
        }

        double area = 0;
        for (int x = xA; x + 1 <= xB; x++) {
            area += (sequences.get(x) + sequences.get(x + 1)) * 0.5;
        }

        return area;
    }
}
