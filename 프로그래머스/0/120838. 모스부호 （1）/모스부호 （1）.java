class Solution {
    public String solution(String letter) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();
        for(String token : letter.split(" ")) {
            for(int i=0; i<26; i++) {
                if(token.equals(code[i])) {
                    sb.append((char) ('a' + i));
                    break;
                }
            }
        }
        return sb.toString();
    }
}