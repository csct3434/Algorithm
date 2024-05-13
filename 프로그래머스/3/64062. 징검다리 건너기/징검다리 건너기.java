class Solution {

    private class SegmentTree {

        private final int[] tree;
        private final int count;

        public SegmentTree(int[] data) {
            tree = new int[data.length * 4];
            count = data.length;
            init(data, 1, 0, count - 1);
        }

        private int init(int[] data, int node, int start, int end) {
            if (start == end) {
                return tree[node] = data[start];
            }

            int mid = (start + end) / 2;
            return tree[node] = Math.max(
                init(data, node * 2, start, mid),
                init(data, node * 2 + 1, mid + 1, end)
            );
        }

        public int max(int left, int right) {
            return max(1, 0, count - 1, left, right);
        }

        private int max(int node, int start, int end, int left, int right) {
            if (end < left || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return Math.max(
                max(node * 2, start, mid, left, right),
                max(node * 2 + 1, mid + 1, end, left, right)
            );
        }
    }

    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        SegmentTree st = new SegmentTree(stones);

        for (int i = 0; i + k - 1 < stones.length; i++) {
            answer = Math.min(answer, st.max(i, i + k - 1));
        }

        return answer;
    }
}