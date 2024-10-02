import java.util.*;

class Solution {

    private final Set<Integer> bannedMasks = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, user_id, banned_id, 0);
        return bannedMasks.size();
    }

    private void dfs(int depth, String[] user_id, String[] banned_id, int bannedMask) {
        if(depth == banned_id.length) {
            bannedMasks.add(bannedMask);
            return;
        }

        for(int i=0; i<user_id.length; i++) {
            if((bannedMask & (1 << i)) > 0) continue;
            if(check(user_id[i], banned_id[depth]))  {
                dfs(depth + 1, user_id, banned_id, (bannedMask | (1 << i)));
            }
        }
    }

    private boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) return false;
        for(int i=0; i<userId.length(); i++) {
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        return true;
    }
}