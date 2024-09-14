class Solution {
    public String solution(int age) {
        StringBuilder ans = new StringBuilder();
        while(age > 0) {
            ans.insert(0, (char) ('a' + (age % 10)));
            age /= 10;
        }
        return ans.toString();
    }
}