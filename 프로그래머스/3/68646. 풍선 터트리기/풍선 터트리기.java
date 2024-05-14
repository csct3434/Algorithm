class Solution {
    
    private static class SegmentTree {
        int[] tree;
        int count;
        public SegmentTree(int[] data) {
            count = data.length;
            tree = new int[count * 4];
            init(1, data, 0, count-1);
        }
        private int init(int node, int[] data, int start, int end) {
            if(start == end) {
                tree[node] = data[start];
                return tree[node];
            }
            int mid = (start + end) / 2;
            return tree[node] = Math.min(
                init(node * 2, data, start, mid),
                init(node * 2 + 1, data, mid+1, end));
        }
        public int min(int left, int right) {
            return min(1, 0, count-1, left, right);
        }
        private int min(int node, int start, int end, int left, int right) {
            if(start > right || end < left) return Integer.MAX_VALUE;
            if(left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return Math.min(
                min(node * 2, start, mid, left, right),
                min(node * 2 + 1, mid+1, end, left, right));
        }
    }
    
    public int solution(int[] a) {
        int answer = Math.min(2, a.length);
        SegmentTree st = new SegmentTree(a);
        for(int i=1; i<a.length-1; i++) {
            if(a[i] < st.min(0, i-1) || a[i] < st.min(i+1, a.length-1)) answer++;
        }
        return answer;
    }
}