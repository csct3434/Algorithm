class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++) {
            answer[i] = solve(quiz[i]) ? "O" : "X";
        }
        return answer;
    }
    
    private boolean solve(String quiz) {
        String[] t = quiz.split(" = ");
        String[] l = t[0].split(" ");
        int right = Integer.parseInt(t[1]);
        int n1 = Integer.parseInt(l[0]);
        int n2 = Integer.parseInt(l[2]);
        int left = l[1].equals("+") ? n1 + n2 : n1 - n2;
        return left == right;
    }
}