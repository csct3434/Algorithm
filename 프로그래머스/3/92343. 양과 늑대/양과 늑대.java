import java.util.*;

class Solution {
    
    private static final int SHEEP = 0, WOLF = 1;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Node[] nodes = new Node[info.length];
        for(int i=0; i<info.length; i++) {
            Node node = new Node(i, info[i]);
            nodes[i] = node;
        }
        for(int[] edge : edges) nodes[edge[0]].childNodes.add(nodes[edge[1]]);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 1});
        while(!queue.isEmpty()) {
            int[] status = queue.remove();
            answer = Math.max(answer, status[0]);
            bfs(queue, status, nodes[0]);
        }
        return answer;
    }
    
    private void bfs(Queue<int[]> queue, int[] status, Node root) {
        int sheeps = status[0];
        int wolves = status[1];
        int visited = status[2];
        
        Queue<Node> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(root);
        
        while(!bfsQueue.isEmpty()) {
            Node node = bfsQueue.remove();
            for(Node child : node.childNodes) {
                if( (visited & (1 << child.number)) > 0 ) {
                    bfsQueue.add(child);
                    continue;
                }
                if(child.type == SHEEP) {
                    queue.add(new int[]{sheeps + 1, wolves, visited | (1 << child.number)});
                } else if (wolves + 1 < sheeps) {
                    queue.add(new int[]{sheeps, wolves + 1, visited | (1 << child.number)});
                }
            }
        }
    }
    
    private static final class Node {
        private final int number;
        private final int type;
        private final List<Node> childNodes = new ArrayList<>();
        public Node(int number, int type) {
            this.number = number;
            this.type = type;
        }
    }
}