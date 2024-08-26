class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipped = new boolean[26];
        for(int i=0; i<skip.length(); i++) {
            skipped[skip.charAt(i) - 'a'] = true;
        }
        for(int i=0; i<s.length(); i++) {
            int c = s.charAt(i), count = 0, idx = 0;
            while(count < index) {
                if(!skipped[(c - 'a' + ++idx) % 26 ]) count++;
            }
            answer.append((char) ('a' + (c - 'a' + idx) % 26));
        }
        return answer.toString();
    }
}