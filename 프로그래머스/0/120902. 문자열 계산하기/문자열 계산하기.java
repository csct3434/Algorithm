import java.util.*;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.replace(" - ", " + -").split(" \\+ ")).mapToInt(Integer::parseInt).sum();
    }
}