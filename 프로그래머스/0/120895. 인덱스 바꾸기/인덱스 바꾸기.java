class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder(my_string);
        char c = sb.charAt(num1);
        sb.setCharAt(num1, sb.charAt(num2));
        sb.setCharAt(num2, c);
        return sb.toString();
    }
}