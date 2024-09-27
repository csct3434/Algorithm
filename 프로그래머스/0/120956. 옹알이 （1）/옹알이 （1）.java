import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling).filter(s -> s.replaceAll("aya|ye|ma|woo", "").length() == 0).count();
    }
}