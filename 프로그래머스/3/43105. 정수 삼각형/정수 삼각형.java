class Solution {
    public int solution(int[][] triangle) {
        for(int row = 1; row < triangle.length; row++) {
            triangle[row][0] += triangle[row - 1][0];
            for(int col = 1; col < row; col++) {
                triangle[row][col] += Math.max(triangle[row - 1][col - 1], triangle[row - 1][col]);
            }
            triangle[row][row] += triangle[row - 1][row - 1];
        }
        
        int answer = 0;
        for(int i=0; i<triangle.length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        return answer;
    }
}