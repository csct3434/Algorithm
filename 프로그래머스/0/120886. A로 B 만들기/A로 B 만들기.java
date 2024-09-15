import java.util.*;

class Solution {
    public int solution(String before, String after) {
        return sort(before).equals(sort(after)) ? 1 : 0;
    }
    
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}