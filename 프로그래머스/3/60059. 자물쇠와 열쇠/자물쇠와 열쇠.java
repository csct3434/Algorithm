import java.util.*;

class Solution {
    
    int M, N;
    List<int[]> lockCells;
    int lockArr[][];
    
    public boolean solution(int[][] key, int[][] lock) {
        init(key, lock);
        for(int i=0; i<4; i++) {
            if(solve(key, lock)) return true;
            key = rotate(key);
        }
        return false;
    }
    
    private void init(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        lockCells = new ArrayList<>();
        lockArr = new int[2 * M + N][2 * M + N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(lock[i][j] == 0) lockCells.add(new int[]{i + M, j + M});
                lockArr[i+M][j+M] = lock[i][j];
            }
        }
    }
    
    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] temp = new int[M][M];
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j] = key[M - 1 - j][i];
            }
        }
        return temp;
    }
    
    private boolean solve(int[][] key, int[][] lock) {
        List<int[]> keyCells = new ArrayList<>();
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                if(key[i][j] == 1) keyCells.add(new int[]{i, j});
            }
        }
        int[][] keyArr = new int[2 * M + N][2 * M + N];
        int seq = 1;
        for(int i=0; i<=N+M; i++) {
            for(int j=0; j<=N+M; j++) {
                boolean possible = true;
                for(int[] k : keyCells) {
                    if(lockArr[k[0] + i][k[1] + j] == 1) {
                        possible = false;
                        break;
                    }
                    keyArr[k[0] + i][k[1] + j] = seq;
                }
                if(possible) {
                    int finalSeq = seq;
                    if(lockCells.stream().allMatch(lc -> keyArr[lc[0]][lc[1]] == finalSeq)) return true;
                }
                seq++;
            }
        }
        return false;
    }
}