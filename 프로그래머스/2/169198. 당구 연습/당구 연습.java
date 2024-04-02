class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i=0; i<balls.length; i++) {
            answer[i] = solve(m, n, startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }
    
    private int solve(int m, int n, int startX, int startY, int targetX, int targetY) {
        double dist = Integer.MAX_VALUE;
        
        // 위쪽
        if((startX != targetX) || (startY > targetY)) {
            dist = Math.min(dist, Math.pow(startX - targetX, 2) + Math.pow(2 * n - startY - targetY, 2));
        }
        // 왼쪽
        if((startY != targetY) || (startX < targetX)) {
            dist = Math.min(dist, Math.pow(startX + targetX, 2) + Math.pow(startY - targetY, 2));
        }
        // 아래쪽
        if((startX != targetX) || (startY < targetY)) {
            dist = Math.min(dist, Math.pow(startX - targetX, 2) + Math.pow(startY + targetY, 2));
        }
        // 오른쪽
        if((startY != targetY) || (startX > targetX)) {
            dist = Math.min(dist, Math.pow(2 * m - startX - targetX, 2) + Math.pow(startY - targetY, 2));
        }
        
        // 왼쪽 위 대각선
        if(tan(startX, n - startY) == tan(targetX, n - targetY) && startX < targetX) {
            dist = Math.min(dist, Math.pow(startX + targetX, 2) + Math.pow(2 * n - startY - targetY, 2));
        }
        // 오른쪽 위 대각선
        if(tan(m - startX, n - startY) == tan(m - targetX, n - targetY) && startX < targetX) {
            dist = Math.min(dist, Math.pow(2 * m - startX - targetX, 2) + Math.pow(2 * n - startY - targetY, 2));
        }
        // 왼쪽 아래 대각선
        if(tan(startX, startY) == tan(targetX, targetY) && startX < targetX) {
            dist = Math.min(dist, Math.pow(startX + targetX, 2) + Math.pow(startY + targetY, 2));
        }
        // 오른쪽 아래 대각선
        if(tan(m - startX, startY) == tan(m - targetX, targetY) && startX > targetX) {
            dist = Math.min(dist, Math.pow(2 * m - startX - targetX, 2) + Math.pow(startY + targetY, 2));
        }
        
        return (int) dist;
    }
    
    private double tan(double x, double y) {
        return y / x;
    }
}