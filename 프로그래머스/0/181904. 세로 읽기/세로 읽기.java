class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder ans = new StringBuilder();
        for(int i = c-1; i < my_string.length(); i += m) ans.append(my_string.charAt(i));
        return ans.toString();
    }
}