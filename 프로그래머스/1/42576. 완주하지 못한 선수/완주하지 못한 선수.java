import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(completion)
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        
        for(String p : participant) {
            if(!map.containsKey(p) || map.get(p) == 0) {
                return p;
            }
            map.put(p, map.get(p) - 1);
        }
        
        return "";
    }
}