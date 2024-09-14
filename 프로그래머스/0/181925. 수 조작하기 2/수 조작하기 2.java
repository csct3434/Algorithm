import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer, Character> op = new HashMap<>();
        op.put(1, 'w');
        op.put(-1, 's');
        op.put(10, 'd');
        op.put(-10, 'a');
        StringBuilder result = new StringBuilder();
        for(int i=1; i<numLog.length; i++) result.append(op.get(numLog[i] - numLog[i-1]));
        return result.toString();
    }
}