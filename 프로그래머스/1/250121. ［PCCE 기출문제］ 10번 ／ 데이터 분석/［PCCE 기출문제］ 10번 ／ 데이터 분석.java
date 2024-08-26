import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> colMap = new HashMap<>();
        colMap.put("code", 0); colMap.put("date", 1); colMap.put("maximum", 2); colMap.put("remain", 3);
        return Arrays.stream(data)
            .filter(d -> d[colMap.get(ext)] < val_ext)
            .sorted((a, b) -> a[colMap.get(sort_by)] - b[colMap.get(sort_by)])
            .toArray(int[][]::new);
    }
}