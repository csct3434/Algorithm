class Solution {
    public int solution(String num_str) {
        return num_str.chars().map(n -> n - '0').sum();
    }
}