import java.util.stream.*;

class Solution {
    public String[] solution(String[] names) {
        return IntStream.rangeClosed(0, (names.length - 1) / 5).mapToObj(i -> names[i * 5]).toArray(String[]::new);
    }
}