import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0, j = 0;
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        while(i < arr.length) {
            if(stk.isEmpty()) {
                stk.add(arr[i++]);
            } else {
                if(stk.peekLast() < arr[i]) stk.addLast(arr[i++]);
                else stk.removeLast();
            }
        }
        int[] answer = new int[stk.size()];
        for(i=0; i<answer.length; i++) {
            answer[i] = stk.removeFirst();
        }
        return answer;
    }
}