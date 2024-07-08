class Solution {
    
    private static final int INF = 100000000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][] dist = init(n, fares);
        for(int k=1; k<=n; k++) {
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return answer;
    }
    
    private int[][] init(int n, int[][] fares) {
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                dist[i][j] = INF;
            }
            dist[i][i] = 0;
        }
        for(int[] fare : fares) {
            dist[fare[0]][fare[1]] = dist[fare[1]][fare[0]] = fare[2];
        }
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }
}