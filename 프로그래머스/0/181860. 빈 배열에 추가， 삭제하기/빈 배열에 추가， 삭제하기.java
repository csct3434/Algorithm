import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayDeque<Integer> X = new ArrayDeque<>();
        for(int i=0; i<flag.length; i++) {
            if(flag[i]) for(int j=0; j < arr[i] * 2; j++) X.addLast(arr[i]);
            else for(int j=0; j<arr[i]; j++) X.removeLast();
        }
        int[] answer = new int[X.size()];
        for(int i=0; i<answer.length; i++) answer[i] = X.removeFirst();
        return answer;
    }
}