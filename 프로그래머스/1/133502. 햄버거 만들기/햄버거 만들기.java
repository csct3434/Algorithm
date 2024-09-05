import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(ingredient[0]);
        for(int i=1; i<ingredient.length; i++) {
            if(ingredient[i] == 1 && deque.size() >= 3) {
                int a = deque.removeLast();
                int b = deque.removeLast();
                int c = deque.removeLast();
                if(a == 3 && b == 2 && c == 1) {
                    answer++;
                } else {
                    deque.add(c);
                    deque.add(b);
                    deque.add(a);
                    deque.add(ingredient[i]);
                }
            } else {
                deque.add(ingredient[i]);
            }
        }
        return answer;
    }
}