import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0, N = board.length;
        int[] lastPosition = new int[N];
        initLastPosition(lastPosition, board, N);
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        for(int col : moves) {
            if(lastPosition[--col] >= N) continue;
            int type = board[lastPosition[col]++][col];
            if(!basket.isEmpty() && basket.peekLast() == type) {
                basket.removeLast();
                answer += 2; 
            } else {
                basket.addLast(type);
            }
        }
        return answer;
    }
    
    private void initLastPosition(int[] lastPosition, int[][] board, int N) {
        for(int col = 0; col < N; col++) {
            lastPosition[col] = N;
            for(int row = 0; row < N; row++) {
                if(board[row][col] != 0) {
                    lastPosition[col] = row;
                    break;
                }
            }
        }
    }
}