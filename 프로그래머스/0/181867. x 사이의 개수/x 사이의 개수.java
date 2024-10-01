import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        for(char c : myString.toCharArray()) {
            if(c == 'x') {
                answer.add(count);
                count = 0;
                continue;
            }
            count++;
        }
        answer.add(count);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}