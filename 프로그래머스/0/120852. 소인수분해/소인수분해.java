import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int d = 2;
        while(n > 1) {
            if(n % d == 0) {
                answer.add(d);
                while(n % d == 0) n /= d;
            }
            d++;
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}