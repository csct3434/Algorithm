class Solution {
    public String solution(String my_string, int n) {
        StringBuilder ans = new StringBuilder();
        for(String s : my_string.split("")) ans.append(s.repeat(n));
        return ans.toString();
    }
}