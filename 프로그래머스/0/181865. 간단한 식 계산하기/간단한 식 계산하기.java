class Solution {
    public int solution(String binomial) {
        String[] token = binomial.split(" ");
        int num1 = Integer.parseInt(token[0]), num2 = Integer.parseInt(token[2]);
        if(token[1].equals("+")) return num1 + num2;
        if(token[1].equals("-")) return num1 - num2;
        return num1 * num2;
    }
}