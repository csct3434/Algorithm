class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s);
        for(int i=0, count = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                count = 0;
                continue;
            }
            answer.setCharAt(i, count++ % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        return answer.toString();
    }
}