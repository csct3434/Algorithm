import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] board) {
        int countO = 0, countX = 0;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i].charAt(j) == 'O') countO++;
                else if(board[i].charAt(j) == 'X') countX++;
            }
        }
        
        if(countX > countO || countO - countX > 1) {
            return 0;
        }
        
        boolean winO = checkWin('O', board);
        boolean winX = checkWin('X', board);
        
        if(winO && winX)    return 0;
        if(winO)    return countO == countX + 1 ? 1 : 0;
        if(winX)    return countO == countX ? 1 : 0;
        return 1;
    }
    
    private boolean checkWin(char c, String[] board) {
        for(int i=0; i<3; i++) {
            int fi = i;
            if(IntStream.range(0, 3).allMatch(j -> board[fi].charAt(j) == c)) {
                return true;
            }
            if(IntStream.range(0, 3).allMatch(j -> board[j].charAt(fi) == c)) {
                return true;
            }
        }
        
        if(IntStream.range(0, 3).allMatch(i -> board[i].charAt(i) == c)) {
            return true;
        }
        if(IntStream.range(0, 3).allMatch(i -> board[2 - i].charAt(i) == c)) {
            return true;
        }
        
        return false;
    }
}