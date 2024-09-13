import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        set.retainAll(Arrays.asList(s2));
        return set.size();
    }
}