import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("[a-zA-Z]")).filter(s -> s.length() != 0).mapToInt(Integer::parseInt).sum();
    }
}