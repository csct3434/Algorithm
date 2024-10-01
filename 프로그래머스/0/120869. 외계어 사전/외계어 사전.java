import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        return Arrays.stream(dic).anyMatch(d -> check(spell, d)) ? 1 : 2;
    }

    private boolean check(String[] spell, String dict) {
        if(dict.length() < spell.length) return false;
        boolean[] valid = new boolean[26];
        for(String s : spell) valid[s.charAt(0) - 'a'] = true;
        for(char c : dict.toCharArray()) {
            if(!valid[c - 'a']) return false;
            valid[c - 'a'] = false;
        }
        return true;
    }
}