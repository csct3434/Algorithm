import java.util.*;

class Solution {
    
    public int solution(String[] user_id, String[] banned_id) {
        List<List<Integer>> matched_id = new ArrayList<>();
        
        for(String pattern : banned_id) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<user_id.length; i++) {
                if(matches(user_id[i], pattern)) {
                    temp.add(i);
                }
            }
            matched_id.add(temp);
        }
        
        Set<Integer> masks = new HashSet<>();
        masks.add(0);
        
        for(List<Integer> ids : matched_id) {
            Set<Integer> temp = new HashSet<>();
            for(int mask : masks) {
                for(int id : ids) {
                    if((mask & (1 << id)) == 0) {
                        temp.add(mask | (1 << id));
                    }
                }
            }
            masks = temp;
        }
        
        return masks.size();
    }
    
    private boolean matches(String id, String pattern) {
        if(id.length() != pattern.length()) return false;
        for(int i=0, len = id.length(); i<len; i++) {
            if(pattern.charAt(i) != '*' && id.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}