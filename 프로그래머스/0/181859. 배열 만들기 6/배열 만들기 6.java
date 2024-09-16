import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++) {
            if(stk.isEmpty() || stk.peekLast() != arr[i]) stk.addLast(arr[i]);
            else stk.removeLast(); 
        }
        if(stk.isEmpty()) return new int[]{-1};
        int[] answer = new int[stk.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = stk.removeFirst();
        }
        return answer;
    }
}