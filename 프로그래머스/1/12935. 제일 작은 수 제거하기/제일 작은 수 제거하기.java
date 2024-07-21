import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int minValue = Arrays.stream(arr).min().orElse(-1);
        return Arrays.stream(arr).filter(n -> n != minValue).toArray();
    }
}