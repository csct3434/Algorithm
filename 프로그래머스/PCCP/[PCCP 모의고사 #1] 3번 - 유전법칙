class Solution {

    private static String[] sequence = new String[]{"RR", "Rr", "Rr", "rr"};

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = resolve(queries[i][0], queries[i][1]);
        }

        return answer;
    }

    private String resolve(int n, long p) {
        if (n < 3) {
            return n == 1 ? "Rr" : sequence[(int) p - 1];
        }

        long N = (long) Math.pow(4, n - 2);
        if (p <= N) {
            return "RR";
        }
        if (p > 3 * N) {
            return "rr";
        }

        return resolve(n - 1, p - N * ((p - 1) / N));
    }
}
