import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean[] delete_arr = new boolean[1001];
        for(int e : delete_list) delete_arr[e] = true;
        return Arrays.stream(arr).filter(e -> !delete_arr[e]).toArray();
    }
}