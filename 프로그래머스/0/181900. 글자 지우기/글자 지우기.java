import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> deleted = new HashSet<>();
        for(int i : indices) deleted.add(i);
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<my_string.length(); i++) if(!deleted.contains(i)) answer.append(my_string.charAt(i));
        return answer.toString();
    }
}