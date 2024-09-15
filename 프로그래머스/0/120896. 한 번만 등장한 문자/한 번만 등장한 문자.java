class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++) {
            if(s.replace(""+c,"").length() + 1 == s.length()) sb.append(c);
        }
        return sb.toString();
    }
}