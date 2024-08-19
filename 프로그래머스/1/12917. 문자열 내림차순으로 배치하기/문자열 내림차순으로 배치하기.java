import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .sorted((c1, c2) -> c2 - c1)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
