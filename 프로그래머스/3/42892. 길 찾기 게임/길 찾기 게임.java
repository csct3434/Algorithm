import java.util.*;

class Solution {

    private final List<Integer> preorderSequences = new ArrayList<>();
    private final List<Integer> postorderSequences = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        int[][] nodes = new int[nodeinfo.length][3];
        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i][0] = nodeinfo[i][0];
            nodes[i][1] = nodeinfo[i][1];
            nodes[i][2] = i+1;
        }
        Arrays.sort(nodes, Comparator.comparingInt(n -> n[0]));
        preorder(nodes, 0, nodes.length - 1);
        postorder(nodes, 0, nodes.length - 1);
        for(int i=0; i<nodeinfo.length; i++) {
            answer[0][i] = preorderSequences.get(i);
            answer[1][i] = postorderSequences.get(i);
        }
        return answer;
    }

    private void preorder(int[][] nodes, int from, int to) {
        if(from >= to) {
            if(from == to) preorderSequences.add(nodes[from][2]);
            return;
        }
        int rootIndex = findRootIndex(nodes, from, to);
        preorderSequences.add(nodes[rootIndex][2]);
        preorder(nodes, from, rootIndex - 1);
        preorder(nodes, rootIndex + 1, to);
    }

    private void postorder(int[][] nodes, int from, int to) {
        if(from >= to) {
            if(from == to) postorderSequences.add(nodes[from][2]);
            return;
        }
        int rootIndex = findRootIndex(nodes, from, to);
        postorder(nodes, from, rootIndex - 1);
        postorder(nodes, rootIndex + 1, to);
        postorderSequences.add(nodes[rootIndex][2]);
    }

    private int findRootIndex(int[][] nodes, int from, int to) {
        int rootIndex = from;
        for(int i = from + 1; i <= to; i++) {
            if(nodes[rootIndex][1] < nodes[i][1]) {
                rootIndex = i;
            }
        }
        return rootIndex;
    }
}