import java.util.stream.*;
import java.util.*;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).mapToDouble(i -> i).average().orElse(0.0);
    }
}