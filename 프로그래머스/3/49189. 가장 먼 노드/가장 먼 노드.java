import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0, maxDist = 0;
        List<List<Integer>> graph = buildGraph(n, edge);
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n+1];
        
        dist[1] = 1;
        queue.add(1);
        while(!queue.isEmpty()) {
            int node = queue.remove();
            maxDist = Math.max(maxDist, dist[node]);
            
            for(int nextNode : graph.get(node)) {
                if(dist[nextNode] == 0) {
                    queue.add(nextNode);
                    dist[nextNode] = dist[node] + 1;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(dist[i] == maxDist) {
                answer++;
            }
        }
        return answer;
    }
    
    private List<List<Integer>> buildGraph(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>()); 
        }
        for(int[] e : edge) { 
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }
}