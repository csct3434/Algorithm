import java.util.*;

class Solution {
    
    private static class SegmentTree {
        int n;
        int[] tree;
        public SegmentTree(int[][] scores) {
            n = scores.length;
            tree = new int[4 * n];
            init(1, 0, n-1, scores);
        }
        private int init(int node, int start, int end, int[][] scores) {
            if(start == end) {
                return tree[node] = scores[start][1];
            }
            int mid = (start + end) / 2;
            return tree[node] = Math.max(
                init(node * 2, start, mid, scores),
                init(node * 2 + 1, mid + 1, end, scores));
        }
        public int max(int left, int right) {
            return max(1, 0, n-1, left, right);
        }
        private int max(int node, int start, int end, int left, int right) {
            if(end < left || start > right) {
                return 0;
            }
            if(start >= left && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return Math.max(
                max(node * 2, start, mid, left, right),
                max(node * 2 + 1, mid + 1, end, left, right)
            );
        }
    }
    
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        SegmentTree st = new SegmentTree(scores);
        Set<int[]> passed = new HashSet<>();
        for(int i=0, n = scores.length; i<n; i++) {
            int left = i+1;
            if(left == n || (left < n && scores[i][1] >= st.max(left, n-1))) {
                passed.add(scores[i]);
            }
        }
        if(!passed.contains(wanho)) return -1;
        int wanhoScore = wanho[0] + wanho[1], wanhoRank = 1;
        for(int[] score : passed) {
            if(score[0] + score[1] > wanhoScore) wanhoRank++;
        }
        return wanhoRank;
    }
}