import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = Character.valueOf((char) (base + (c - base + n) % 26));
            }
            sb.append(c);
        }
        return sb.toString();
    }
}