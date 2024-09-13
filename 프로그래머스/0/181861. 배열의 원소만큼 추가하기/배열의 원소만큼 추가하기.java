import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr).boxed().flatMap(n -> Collections.nCopies(n, n).stream()).mapToInt(n -> n).toArray();
    }
}