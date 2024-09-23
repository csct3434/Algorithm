class Solution {
    public String solution(String polynomial) {
        String[] token = polynomial.split(" \\+ ");
        int a = 0, b = 0;
        for(String t : token) {
            if(t.contains("x")) {
                if(t.length() == 1) a += 1;
                else a += Integer.parseInt(t.substring(0, t.length() - 1));
            }
            else b += Integer.parseInt(t);
        }
        String answer = "";
        if(a != 0) {
            if(a == 1) answer += "x";
            else answer += a + "x";
        }
        if(answer.length() != 0 && b != 0) answer += " + ";
        if(b != 0) answer += b;
        return answer;
    }
}