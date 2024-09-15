import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[][] arr = new int[emergency.length][];
        for(int i=0; i<emergency.length; i++) {
            arr[i] = new int[]{i, emergency[i]};
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        for(int i=0; i<arr.length; i++) {
            emergency[arr[i][0]] = i + 1;
        }
        return emergency;
    }
}